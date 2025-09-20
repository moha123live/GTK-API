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

    @Override
    @Transactional
    public TransactionResponseDto createTransaction(TransactionRequestDto req) {
        // 1. Validate supplier and product existence
        Integer supplierId = req.getPurchase().getSupId();
        Supplier supplier = supplierRepository.findById(supplierId)
                .orElseThrow(() -> new RuntimeException(AppMessages.SUPPLIER_NOT_FOUND));
        Product product = productRepository.findById(req.getPurchase().getProductId())
                .orElseThrow(() -> new RuntimeException(AppMessages.PRODUCT_NOT_FOUND));

        // 2. Save purchase record
        Purchase purchase = PurchaseMapper.toEntity(req.getPurchase(), supplier, product);
        purchase = purchaseRepository.save(purchase);

        // 3. Update supplier’s outstanding balance (Balance Due)
        BigDecimal oldSupplierBalance = supplier.getBalanceDue() != null ? supplier.getBalanceDue() : BigDecimal.ZERO;
        BigDecimal newSupplierBalance = oldSupplierBalance.add(purchase.getAmount());
        supplier.setBalanceDue(newSupplierBalance);
        supplierRepository.save(supplier);

        // 4. Save sales records and update each customer’s balance
        List<Sale> savedSales = new ArrayList<>();
        if (req.getSales() != null) {
            for (SaleRequestDto saleDto : req.getSales()) {
                Customer customer = customerRepository.findById(saleDto.getCustId())
                        .orElseThrow(() -> new RuntimeException(AppMessages.CUSTOMER_NOT_FOUND));
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

        List<Ledger> ledgers = new ArrayList<>();

        // 6. Supplier ledger (purchase credit for the day)
        Ledger supplierLedger = ledgerRepository.findByDateAndReferenceTypeAndEntityTypeAndEntityId(
                purchase.getDate(),
                Ledger.ReferenceType.PURCHASE,
                Ledger.EntityType.SUPPLIER,
                purchase.getSupplier().getSupId()).orElse(null);
        if (supplierLedger != null) {
            supplierLedger.setCredit(supplierLedger.getCredit().add(purchase.getAmount()));
        } else {
            supplierLedger = LedgerMapper.toPurchaseLedger(purchase);
        }
        ledgers.add(supplierLedger);

        // 7. Customer ledgers (sales debit for the day)
        for (Sale sale : savedSales) {
            Ledger customerLedger = ledgerRepository.findByDateAndReferenceTypeAndEntityTypeAndEntityId(
                    purchase.getDate(),
                    Ledger.ReferenceType.SALE,
                    Ledger.EntityType.CUSTOMER,
                    sale.getCustomer().getCusId()).orElse(null);
            if (customerLedger != null) {
                customerLedger.setDebit(customerLedger.getDebit().add(sale.getNetAmount()));
            } else {
                customerLedger = LedgerMapper.toSaleLedger(sale);
            }
            ledgers.add(customerLedger);
        }
        ledgers = ledgerRepository.saveAll(ledgers);
        return TransactionMapper.toResponseDto(purchase, savedSales, billSummary);
    }
}
