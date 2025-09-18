package com.moha123live.gtk_api.dto.responseDto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class BillSummaryResponseDto {
    private Integer billId;
    private Integer purchaseId;
    private Integer totalQty;
    private BigDecimal totalBagWeight;
    private BigDecimal totalWeight;
    private BigDecimal totalAmount;
    private BigDecimal totalNetAmount;
}
