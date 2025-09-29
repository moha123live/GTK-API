package com.moha123live.gtk_api.dto.requestDto;

import java.math.BigDecimal;
import java.time.LocalDate;
import com.moha123live.gtk_api.util.AppMessages;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PurchaseRequestDto {

    @NotNull(message = AppMessages.SUPPLIER_ID_NOT_FOUND)
    private Integer supId;

    @Size(max = 25, message = AppMessages.PURCHASE_BILL_LENGTH)
    private String billNo;

    @NotNull(message = AppMessages.PURCHASE_DATE_REQUIRED)
    private LocalDate billDate;

    private Integer totalQty;

    private BigDecimal totalWeight;

    private BigDecimal totalAmount;

}
