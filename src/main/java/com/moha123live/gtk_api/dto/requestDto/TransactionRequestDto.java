package com.moha123live.gtk_api.dto.requestDto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
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

    @Data
    public static class Search {

        @NotNull(message = AppMessages.PURCHASE_DATE_REQUIRED)
        private LocalDate date;

        @NotNull(message = AppMessages.SUPPLIER_ID_REQUIRED)
        private Integer supId;

        @NotNull(message = AppMessages.PRODUCT_ID_REQUIRED)
        private Integer prodId;

    }

    @Data
    public static class SearchBillNo {

        @NotNull(message = AppMessages.PURCHASE_DATE_REQUIRED)
        private LocalDate date;

        @NotNull(message = AppMessages.PURCHASE_BILLNO_REQUIRED)
        private String billNo;

        @NotNull(message = AppMessages.PRODUCT_ID_REQUIRED)
        private Integer prodId;

    }
}
