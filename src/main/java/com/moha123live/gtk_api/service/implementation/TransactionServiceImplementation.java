package com.moha123live.gtk_api.service.implementation;

import com.moha123live.gtk_api.dto.requestDto.*;
import com.moha123live.gtk_api.dto.responseDto.TransactionResponseDto;
import com.moha123live.gtk_api.mapper.*;
import com.moha123live.gtk_api.model.*;
import com.moha123live.gtk_api.repository.*;
import com.moha123live.gtk_api.service.TransactionService;
import com.moha123live.gtk_api.util.AppMessages;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionServiceImplementation implements TransactionService {

    private final PurchaseRepository purchaseRepository;
    private final SaleRepository saleRepository;
    private final BillSummaryRepository billSummaryRepository;
    private final LedgerRepository ledgerRepository;
    private final SupplierRepository supplierRepository;
    private final ProductRepository productRepository;
    private final CustomerRepository customerRepository;

    private Supplier getSupplier(Integer id) {
        Supplier supplier = supplierRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(AppMessages.SUPPLIER_NOT_FOUND));
        return supplier;
    }

    private Product getProduct(Integer id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(AppMessages.PRODUCT_NOT_FOUND));
        return product;
    }

    private Customer getCustomer(Integer id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(AppMessages.CUSTOMER_NOT_FOUND));
        return customer;
    }

    private Purchase getPurchase(Integer id) {
        Purchase purchase = purchaseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(AppMessages.PURCHASE_NOT_FOUND));
        return purchase;
    }

    private List<Sale> getSalesByPurchaseId(Integer id) {
        List<Sale> sales = saleRepository.findByPurchase_PurId(id);
        return sales;
    }

    private BillSummary getBillSummaryByPurchaseId(Integer id) {
        BillSummary billSummary = billSummaryRepository.findByPurchase_PurId(id);
        return billSummary;
    }

    private Ledger saveOrUpdatePurchaseLedger(Purchase purchase) {
        return saveOrUpdatePurchaseLedger(purchase, false);
    }

    private Ledger saveOrUpdatePurchaseLedger(Purchase purchase, Boolean subtractLedger) {
        Ledger ledger = ledgerRepository.findByDateAndReferenceTypeAndEntityTypeAndEntityId(
                purchase.getDate(),
                Ledger.ReferenceType.PURCHASE,
                Ledger.EntityType.SUPPLIER,
                purchase.getSupplier().getSupId()).orElse(null);
        if (ledger != null) {
            BigDecimal currentCredit = ledger.getCredit() != null ? ledger.getCredit() : BigDecimal.ZERO;
            BigDecimal newCredit = subtractLedger ? currentCredit.subtract(purchase.getAmount())
                    : currentCredit.add(purchase.getAmount());
            ledger.setCredit(newCredit);
        } else if (!subtractLedger) {
            ledger = LedgerMapper.toPurchaseLedger(purchase);
        }
        return ledger;
    }

    private Ledger saveOrUpdateSaleLedger(Sale sale) {
        return saveOrUpdateSaleLedger(sale, false);
    }

    private Ledger saveOrUpdateSaleLedger(Sale sale, Boolean subtractLedger) {
        Ledger ledger = ledgerRepository.findByDateAndReferenceTypeAndEntityTypeAndEntityId(
                sale.getDate(),
                Ledger.ReferenceType.SALE,
                Ledger.EntityType.CUSTOMER,
                sale.getCustomer().getCusId()).orElse(null);
        if (ledger != null) {
            BigDecimal currentDebit = ledger.getDebit() != null ? ledger.getDebit() : BigDecimal.ZERO;
            BigDecimal newDebit = subtractLedger ? currentDebit.subtract(sale.getNetAmount())
                    : currentDebit.add(sale.getNetAmount());
            ledger.setDebit(newDebit);
        } else if (!subtractLedger) {
            ledger = LedgerMapper.toSaleLedger(sale);
        }
        return ledger;
    }

    private TransactionResponseDto getTransaction(Purchase purchase) {

        Integer purchaseId = purchase.getPurId();
        List<Sale> sales = getSalesByPurchaseId(purchaseId);
        BillSummary billSummary = getBillSummaryByPurchaseId(purchaseId);

        return TransactionMapper.toResponseDto(purchase, sales, billSummary);
    }

    private TransactionResponseDto save(TransactionRequestDto req) {
        // 1. Validate supplier and product existence
        Integer supId = req.getPurchase().getSupId();
        Integer productId = req.getPurchase().getProductId();
        Supplier supplier = getSupplier(supId);
        Product product = getProduct(productId);

        // 2. Save purchase record
        Purchase purchase = PurchaseMapper.toEntity(req.getPurchase(), supplier, product);
        purchase = purchaseRepository.save(purchase);

        // 3. Update supplier’s outstanding balance (Balance Due)
        BigDecimal oldSupplierBalance = supplier.getBalanceDue() != null ? supplier.getBalanceDue()
                : BigDecimal.ZERO;
        BigDecimal newSupplierBalance = oldSupplierBalance.add(purchase.getAmount());
        supplier.setBalanceDue(newSupplierBalance);
        supplierRepository.save(supplier);

        // 4. Save sales records and update each customer’s balance
        List<Sale> savedSales = new ArrayList<>();
        if (req.getSales() != null) {
            for (SaleRequestDto saleDto : req.getSales()) {

                Integer custId = saleDto.getCustId();
                Customer customer = getCustomer(custId);
                saleDto.setDate(purchase.getDate());

                Sale sale = SaleMapper.toEntity(saleDto, purchase, customer);
                savedSales.add(saleRepository.save(sale));

                BigDecimal currBalance = customer.getCurrBalance() != null ? customer.getCurrBalance()
                        : (customer.getOldBalance() != null ? customer.getOldBalance() : BigDecimal.ZERO);
                BigDecimal saleAmount = sale.getNetAmount() != null ? sale.getNetAmount() : BigDecimal.ZERO;
                customer.setCurrBalance(currBalance.add(saleAmount));
                customerRepository.save(customer);
            }
        }

        // 5. Save bill summary for this purchase
        BillSummary billSummary = BillSummaryMapper.toEntity(req.getBillSummary(), purchase);
        billSummary = billSummaryRepository.save(billSummary);

        // 6. Supplier ledger + Customer ledger
        List<Ledger> ledgers = new ArrayList<>();
        ledgers.add(saveOrUpdatePurchaseLedger(purchase));
        for (Sale sale : savedSales) {
            ledgers.add(saveOrUpdateSaleLedger(sale));
        }
        ledgers = ledgerRepository.saveAll(ledgers);

        return TransactionMapper.toResponseDto(purchase, savedSales, billSummary);
    }

    private void deleteTransactiondetails(Integer id) {
        if (id == null)
            throw new RuntimeException(AppMessages.PURCHASE_ID_REQUIRED);

        Purchase purchase = getPurchase(id);
        List<Sale> sales = getSalesByPurchaseId(id);

        if (billSummaryRepository.existsById(id)) {
            billSummaryRepository.deleteByPurchase_PurId(id);
        }

        List<Ledger> ledgers = new ArrayList<>();

        // Sale Table Deletion
        for (Sale sale : sales) {
            BigDecimal customerNetAmount = sale.getNetAmount() != null ? sale.getNetAmount() : BigDecimal.ZERO;
            Customer customer = getCustomer(sale.getCustomer().getCusId());
            customer.setCurrBalance(customer.getCurrBalance().subtract(customerNetAmount));
            customerRepository.save(customer);
            ledgers.add(saveOrUpdateSaleLedger(sale, true));
            saleRepository.delete(sale);
        }

        // Purchase Table Deletion
        ledgers.add(saveOrUpdatePurchaseLedger(purchase, true));
        BigDecimal supplierAmount = purchase.getAmount() != null ? purchase.getAmount() : BigDecimal.ZERO;
        Supplier supplier = getSupplier(purchase.getSupplier().getSupId());
        supplier.setBalanceDue(supplier.getBalanceDue().subtract(supplierAmount));
        supplierRepository.save(supplier);
        purchaseRepository.delete(purchase);
        ledgerRepository.saveAll(ledgers);
    }

    @Override
    @Transactional
    public TransactionResponseDto createTransaction(TransactionRequestDto req) {
        try {
            return save(req);
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    @Transactional
    public void deleteTransaction(Integer id) {
        try {
            deleteTransactiondetails(id);
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    @Transactional
    public TransactionResponseDto updateTransaction(Integer id, TransactionRequestDto req) {
        try {
            deleteTransactiondetails(id);
            return save(req);
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    @Transactional
    public TransactionResponseDto getTransactionById(Integer id) {
        try {
            Purchase purchase = getPurchase(id);
            return getTransaction(purchase);
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    @Transactional
    public TransactionResponseDto getTransactionBySearch(TransactionRequestDto.Search request) {
        try {
            Purchase purchase = purchaseRepository.findByDateAndSupplier_SupIdAndProduct_productId(request.getDate(), request.getSupId(), request.getProductId())
                    .orElseThrow(() -> new RuntimeException(AppMessages.PURCHASE_NOT_FOUND));
            return getTransaction(purchase);
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    @Transactional
    public TransactionResponseDto getTransactionBySearchBillNo(TransactionRequestDto.SearchBillNo request) {
        try {
            Purchase purchase = purchaseRepository.findByDateAndBillNoAndProduct_productId(request.getDate(), request.getBillNo(), request.getProductId())
                    .orElseThrow(() -> new RuntimeException(AppMessages.PURCHASE_NOT_FOUND));
            return getTransaction(purchase);
        } catch (Exception ex) {
            throw ex;
        }
    }

}
