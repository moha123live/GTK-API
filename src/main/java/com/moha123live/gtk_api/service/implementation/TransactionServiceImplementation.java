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
        System.out.println("req === " + req);
        Supplier supplier = supplierRepository.findById(req.getPurchase().getSupId())
                .orElseThrow(() -> new RuntimeException(AppMessages.SUPPLIER_NOT_FOUND));
        Product product = productRepository.findById(req.getPurchase().getProductId())
                .orElseThrow(() -> new RuntimeException(AppMessages.PRODUCT_NOT_FOUND));

        Purchase purchase = PurchaseMapper.toEntity(req.getPurchase(), supplier, product);
        purchase = purchaseRepository.save(purchase);

        List<Sale> savedSales = new ArrayList<>();
        if (req.getSales() != null) {
            for (SaleRequestDto saleDto : req.getSales()) {
                Customer customer = customerRepository.findById(saleDto.getCustId())
                        .orElseThrow(() -> new RuntimeException(AppMessages.CUSTOMER_NOT_FOUND));
                saleDto.setDate(purchase.getDate());
                Sale sale = SaleMapper.toEntity(saleDto, purchase, customer);
                savedSales.add(saleRepository.save(sale));
            }
        }
        BillSummary billSummary = BillSummaryMapper.toEntity(req.getBillSummary(), purchase);
        billSummary = billSummaryRepository.save(billSummary);

        List<Ledger> ledgers = new ArrayList<>();
        Ledger supplierLedger = LedgerMapper.toPurchaseLedger(purchase);
        ledgers.add(supplierLedger);
        for (Sale sale : savedSales) {
            Ledger customerLedger = LedgerMapper.toSaleLedger(sale);
            ledgers.add(customerLedger);
        }
        ledgers = ledgerRepository.saveAll(ledgers);

        return TransactionMapper.toResponseDto(purchase, savedSales, billSummary, ledgers);
    }

}
