package com.moha123live.gtk_api.dto.responseDto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
public class LedgerResponseDto {
    private Integer id;
    private String entityType;
    private Integer entityId;
    private Integer referenceId;
    private String referenceType;
    private LocalDate date;
    private BigDecimal debit;
    private BigDecimal credit;
    private BigDecimal oldBalance;
    private BigDecimal newBalance;
}
