package com.moha123live.gtk_api.dto.requestDto;

import java.math.BigDecimal;

import com.moha123live.gtk_api.util.AppMessages;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PurchaseItemRequestDto {

    @NotNull(message = AppMessages.PRODUCT_ID_NOT_FOUND)
    private Integer prodId;

    @NotNull(message = AppMessages.PURCHASE_QUANTITY_REQUIRED)
    @Min(value = 1, message = AppMessages.PURCHASE_QUANTITY_MIN)
    private Integer qty;

    @NotNull(message = AppMessages.PURCHASE_WEIGHT_REQUIRED)
    @DecimalMin(value = "0.01", inclusive = true, message = AppMessages.PURCHASE_WEIGHT_POSITIVE)
    private BigDecimal weight;

    @NotNull(message = AppMessages.PURCHASE_RATE_REQUIRED)
    @DecimalMin(value = "0.01", inclusive = true, message = AppMessages.PURCHASE_RATE_POSITIVE)
    private BigDecimal rate;

    @NotNull(message = AppMessages.PURCHASE_AMOUNT_REQUIRED)
    @DecimalMin(value = "0.01", inclusive = true, message = AppMessages.PURCHASE_AMOUNT_POSITIVE)
    private BigDecimal amount;
}
