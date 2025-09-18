package com.moha123live.gtk_api.mapper;

import com.moha123live.gtk_api.dto.requestDto.LedgerRequestDto;
import com.moha123live.gtk_api.dto.responseDto.LedgerResponseDto;
import com.moha123live.gtk_api.model.Ledger;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Component
public class LedgerMapper {

    public Ledger toEntity(LedgerRequestDto req, BigDecimal oldBalance) {
        if (req == null) return null;

        BigDecimal debit = req.getDebit() != null ? req.getDebit() : BigDecimal.ZERO;
        BigDecimal credit = req.getCredit() != null ? req.getCredit() : BigDecimal.ZERO;

        BigDecimal newBalance = oldBalance.add(credit).subtract(debit);

        return Ledger.builder()
                .entityType(Ledger.EntityType.valueOf(req.getEntityType()))
                .entityId(req.getEntityId())
                .referenceId(req.getReferenceId())
                .referenceType(Ledger.ReferenceType.valueOf(req.getReferenceType()))
                .date(req.getDate() != null ? req.getDate() : LocalDateTime.now())
                .debit(debit)
                .credit(credit)
                .oldBalance(oldBalance)
                .newBalance(newBalance)
                .build();
    }

    // From transaction (purchase/sale system-generated)
    public Ledger fromTransaction(
            Ledger.EntityType entityType,
            Integer entityId,
            Ledger.ReferenceType refType,
            Long referenceId,
            BigDecimal debit,
            BigDecimal credit,
            BigDecimal oldBalance
    ) {
        BigDecimal newBalance = oldBalance.add(credit).subtract(debit);

        return Ledger.builder()
                .entityType(entityType)
                .entityId(entityId)
                .referenceId(referenceId)
                .referenceType(refType)
                .date(LocalDateTime.now())
                .debit(debit)
                .credit(credit)
                .oldBalance(oldBalance)
                .newBalance(newBalance)
                .build();
    }

    // To response
    public LedgerResponseDto toResponseDto(Ledger res) {
        if (res == null) return null;

        return LedgerResponseDto.builder()
                .id(res.getLedId())
                .entityType(res.getEntityType().name())
                .entityId(res.getEntityId())
                .referenceId(res.getReferenceId())
                .referenceType(res.getReferenceType().name())
                .date(res.getDate())
                .debit(res.getDebit())
                .credit(res.getCredit())
                .oldBalance(res.getOldBalance())
                .newBalance(res.getNewBalance())
                .build();
    }
}
