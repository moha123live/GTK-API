package com.moha123live.gtk_api.mapper;

import java.math.BigDecimal;

import com.moha123live.gtk_api.dto.responseDto.LedgerResponseDto;
import com.moha123live.gtk_api.model.Ledger;
import com.moha123live.gtk_api.model.Purchase;
import com.moha123live.gtk_api.model.Sale;

public class LedgerMapper {

    public static Ledger toPurchaseLedger(Purchase purchase) {
        return Ledger.builder()
                .entityType(Ledger.EntityType.SUPPLIER)
                .entityId(purchase.getSupplier().getSupId())
                .referenceId(purchase.getPurId())
                .referenceType(Ledger.ReferenceType.PURCHASE)
                .date(purchase.getDate())
                .debit(purchase.getAmount())
                .credit(BigDecimal.ZERO)
                .oldBalance(BigDecimal.ZERO)
                .newBalance(purchase.getAmount())
                .build();
    }

    public static Ledger toSaleLedger(Sale sale) {
        return Ledger.builder()
                .entityType(Ledger.EntityType.CUSTOMER)
                .entityId(sale.getCustomer().getCusId())
                .referenceId(sale.getSaleId())
                .referenceType(Ledger.ReferenceType.SALE)
                .date(sale.getDate())
                .debit(BigDecimal.ZERO)
                .credit(sale.getNetAmount())
                .oldBalance(BigDecimal.ZERO)
                .newBalance(sale.getAmount())
                .build();
    }

    public static LedgerResponseDto toResponseDto(Ledger ledger) {
        return LedgerResponseDto.builder()
                .id(ledger.getLedId())
                .entityType(ledger.getEntityType().name())
                .entityId(ledger.getEntityId())
                .referenceId(ledger.getReferenceId())
                .referenceType(ledger.getReferenceType().name())
                .date(ledger.getDate())
                .debit(ledger.getDebit())
                .credit(ledger.getCredit())
                .oldBalance(ledger.getOldBalance())
                .newBalance(ledger.getNewBalance())
                .build();
    }
}
