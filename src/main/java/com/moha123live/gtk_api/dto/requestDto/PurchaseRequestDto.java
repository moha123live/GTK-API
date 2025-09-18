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

    @Size(max = 10, message = AppMessages.PURCHASE_BILL_LENGTH)
    private String billNo;

    @NotNull(message = AppMessages.PURCHASE_DATE_REQUIRED)
    private LocalDate date;

    @NotNull(message = AppMessages.PURCHASE_RATE_REQUIRED)
    @DecimalMin(value = "0.00", message = AppMessages.PURCHASE_RATE_LENGTH)
    private BigDecimal rate;

    @NotNull(message = AppMessages.PURCHASE_QUANTITY_REQUIRED)
    @Min(value = 1, message = AppMessages.PURCHASE_ATLEAST_QUANITY)
    private Integer qty;

    @NotNull(message = AppMessages.PURCHASE_WEIGHT)
    private BigDecimal weight;

    @NotNull(message = AppMessages.PURCHASE_AMOUNT)
    private BigDecimal amount;
    
}
