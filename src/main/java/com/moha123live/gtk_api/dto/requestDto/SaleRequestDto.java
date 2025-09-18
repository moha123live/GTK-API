package com.moha123live.gtk_api.dto.requestDto;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.moha123live.gtk_api.util.AppMessages;

@Data
public class SaleRequestDto {


    @NotNull(message = AppMessages.SALE_DATE_REQUIRED)
    private LocalDate date;

    @NotNull(message = AppMessages.CUSTOMER_ID_NOT_FOUND)
    private Integer customerId;

    @NotNull(message = AppMessages.SALE_QUANTITY_REQUIRED)
    private Integer qty;

    private BigDecimal bagWeight;

    @NotNull(message = AppMessages.SALE_WEIGHT)
    private BigDecimal weight;

    @DecimalMin(value = "0.0", inclusive = false, message = AppMessages.SALE_BAG_RATE)
    private BigDecimal bagRate;

    @DecimalMin(value = "0.0", message = AppMessages.SALE_COMMISSION_NONNEGATIVE)
    private BigDecimal commission = BigDecimal.ZERO;

    @NotNull(message = AppMessages.SALE_RATE_REQUIRED)
    @DecimalMin(value = "0.00", message = AppMessages.SALE_RATE_LENGTH)
    private BigDecimal rate;

    @NotNull(message = AppMessages.SALE_AMOUNT_REQUIRED)
    @DecimalMin(value = "0.00", message = AppMessages.SALE_AMOUNT_LENGTH)
    private BigDecimal amount;

    @NotNull(message = AppMessages.SALE_NETAMOUNT_REQUIRED)
    @DecimalMin(value = "0.00", message = AppMessages.SALE_NETAMOUNT_LENGTH)
    private BigDecimal netAmount;
}
