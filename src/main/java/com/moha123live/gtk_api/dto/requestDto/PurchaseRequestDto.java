package com.moha123live.gtk_api.dto.requestDto;


import java.math.BigDecimal;
import java.time.LocalDate;

import com.moha123live.gtk_api.util.AppMessages;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PurchaseRequestDto {

    @NotNull(message = AppMessages.SUPPLIER_ID_NOT_FOUND)
    private Integer supId;

    @NotNull(message = AppMessages.PRODUCT_ID_NOT_FOUND)
    private Integer productId;

    @Size(max = 25, message = AppMessages.PURCHASE_BILL_LENGTH)
    private String billNo;

    @NotNull(message = AppMessages.PURCHASE_DATE_REQUIRED)
    private LocalDate date;

    @NotNull(message = AppMessages.PURCHASE_RATE_REQUIRED)
    @DecimalMin(value = "0.01", inclusive = true, message = AppMessages.PURCHASE_RATE_POSITIVE)
    private BigDecimal rate;

    @NotNull(message = AppMessages.PURCHASE_QUANTITY_REQUIRED)
    @Min(value = 1, message = AppMessages.PURCHASE_QUANTITY_MIN)
    private Integer qty;

    @NotNull(message = AppMessages.PURCHASE_WEIGHT_REQUIRED)
    @DecimalMin(value = "0.01", inclusive = true, message = AppMessages.PURCHASE_WEIGHT_POSITIVE)
    private BigDecimal weight;

    @NotNull(message = AppMessages.PURCHASE_AMOUNT_REQUIRED)
    @DecimalMin(value = "0.01", inclusive = true, message = AppMessages.PURCHASE_AMOUNT_POSITIVE)
    private BigDecimal amount;
    
}
