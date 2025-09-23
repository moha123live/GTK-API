package com.moha123live.gtk_api.dto.responseDto;

import lombok.Builder;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
public class SaleResponseDto {
    private Integer saleId;
    private LocalDate date;
    private Integer custId;
    private String custName;
    private Integer qty;
    private BigDecimal bagWeight;
    private BigDecimal weight;
    private BigDecimal bagRate;
    private BigDecimal commission;
    private BigDecimal rate;
    private BigDecimal amount;
    private BigDecimal netAmount;
}
