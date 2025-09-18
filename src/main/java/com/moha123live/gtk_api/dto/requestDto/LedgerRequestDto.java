package com.moha123live.gtk_api.dto.requestDto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.moha123live.gtk_api.util.AppMessages;

@Data
public class LedgerRequestDto {

    @NotNull(message = AppMessages.LEDGER_ENTITY_TYPE_REQUIRED)
    private String entityType;

    @NotNull(message = AppMessages.LEDGER_ENTITY_ID_REQUIRED)
    private Integer entityId;

    private Long referenceId;

    @NotNull(message = AppMessages.LEDGER_REFERENCE_TYPE_REQUIRED)
    private String referenceType;

    private LocalDateTime date;

    private BigDecimal debit;
    private BigDecimal credit;
}
