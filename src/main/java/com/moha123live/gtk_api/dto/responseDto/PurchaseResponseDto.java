package com.moha123live.gtk_api.dto.responseDto;

import lombok.Builder;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
public class PurchaseResponseDto {
    private Integer id;
    private Integer supplierId;
    private String supplierName;
    private Integer productId;
    private String productName;
    private String billNo;
    private LocalDate date;
    private BigDecimal rate;
    private Integer qty;
    private BigDecimal weight;
    private BigDecimal amount;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
