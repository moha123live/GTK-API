package com.moha123live.gtk_api.dto.responseDto;

import lombok.Builder;
import lombok.Data;
import java.util.List;

@Data
@Builder
public class TransactionResponseDto {
    private PurchaseResponseDto purchase;
    private List<SaleResponseDto> sales;
    private BillSummaryResponseDto billSummary;
}
