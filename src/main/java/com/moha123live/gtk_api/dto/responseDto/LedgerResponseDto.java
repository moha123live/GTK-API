package com.moha123live.gtk_api.dto.responseDto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class LedgerResponseDto {
    private Long id;
    private String entityType;
    private Integer entityId;
    private Long referenceId;
    private String referenceType;
    private LocalDateTime date;
    private BigDecimal debit;
    private BigDecimal credit;
    private BigDecimal oldBalance;
    private BigDecimal newBalance;
}
