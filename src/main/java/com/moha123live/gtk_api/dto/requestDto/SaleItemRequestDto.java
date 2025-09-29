package com.moha123live.gtk_api.dto.requestDto;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;

import com.moha123live.gtk_api.util.AppMessages;

@Data
public class SaleItemRequestDto {

    @NotNull(message = AppMessages.PRODUCT_ID_NOT_FOUND)
    private Integer prodId;

    @NotNull(message = AppMessages.SALE_QUANTITY_REQUIRED)
    @Min(value = 1, message = AppMessages.SALE_QUANTITY_MIN)
    private Integer qty;

    private BigDecimal bagWeight;

    @NotNull(message = AppMessages.SALE_WEIGHT_REQUIRED)
    @DecimalMin(value = "0.01", inclusive = true, message = AppMessages.SALE_WEIGHT_POSITIVE)
    private BigDecimal weight;

    @DecimalMin(value = "0.01", inclusive = true, message = AppMessages.SALE_BAG_RATE_POSITIVE)
    private BigDecimal bagRate;

    @DecimalMin(value = "0.00", inclusive = true, message = AppMessages.SALE_COMMISSION_POSITIVE)
    private BigDecimal commission = BigDecimal.ZERO;

    @NotNull(message = AppMessages.SALE_RATE_REQUIRED)
    @DecimalMin(value = "0.01", inclusive = true, message = AppMessages.SALE_RATE_POSITIVE)
    private BigDecimal rate;

    @NotNull(message = AppMessages.SALE_AMOUNT_REQUIRED)
    @DecimalMin(value = "0.01", inclusive = true, message = AppMessages.SALE_AMOUNT_POSITIVE)
    private BigDecimal amount;

    @NotNull(message = AppMessages.SALE_NET_AMOUNT_REQUIRED)
    @DecimalMin(value = "0.01", inclusive = true, message = AppMessages.SALE_NET_AMOUNT_POSITIVE)
    private BigDecimal netAmount;
}
