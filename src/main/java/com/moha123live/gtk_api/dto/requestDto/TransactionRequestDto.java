package com.moha123live.gtk_api.dto.requestDto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.util.List;

import com.moha123live.gtk_api.util.AppMessages;

@Data
public class TransactionRequestDto {

    @NotNull(message = AppMessages.PURCHASE_REQUIRED)
    @Valid
    private PurchaseRequestDto purchase;

    @Valid
    private List<SaleRequestDto> sales;

    @NotNull(message = AppMessages.BillSUMMARY_REQUIRED)
    @Valid
    private BillSummaryRequestDto billSummary;
}
