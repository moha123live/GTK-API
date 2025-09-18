package com.moha123live.gtk_api.dto.requestDto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

import com.moha123live.gtk_api.util.AppMessages;

@Data
public class BillSummaryRequestDto {

    @NotNull(message = AppMessages.BillSUMMARY_QUANTITY_REQUIRED)
    @DecimalMin(value = "0.0", inclusive = false, message = AppMessages.BillSUMMARY_QUANTITY_GREATER_THAN_ZERO)
    private Integer totalQty;

    @NotNull(message = AppMessages.BillSUMMARY_BAGWEIGHT_REQUIRED)
    @DecimalMin(value = "0.0", inclusive = true, message = AppMessages.BillSUMMARY_BAGWEIGHT_GREATER_OR_EQUAL_ZERO)
    private BigDecimal totalBagWeight;

    @NotNull(message = AppMessages.BillSUMMARY_WEIGHT_REQUIRED)
    @DecimalMin(value = "0.0", inclusive = false, message = AppMessages.BillSUMMARY_WEIGHT_GREATER_THAN_ZERO)
    private BigDecimal totalWeight;

    @NotNull(message = AppMessages.BillSUMMARY_AMOUNT_GREATER_THAN_ZERO)
    @DecimalMin(value = "0.0", inclusive = false, message = AppMessages.BillSUMMARY_AMOUNT_GREATER_THAN_ZERO)
    private BigDecimal totalAmount;

    @NotNull(message = AppMessages.BillSUMMARY_NETAMOUNT_REQUIRED)
    @DecimalMin(value = "0.0", inclusive = false, message = AppMessages.BillSUMMARY_NETAMOUNT_GREATER_THAN_ZERO)
    private BigDecimal totalNetAmount;
}
