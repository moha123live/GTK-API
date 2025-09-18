package com.moha123live.gtk_api.mapper;

import com.moha123live.gtk_api.dto.responseDto.TransactionResponseDto;
import com.moha123live.gtk_api.model.*;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TransactionMapper {
    public static TransactionResponseDto toResponseDto(
            Purchase purchase,
            List<Sale> sales,
            BillSummary billSummary,
            List<Ledger> ledgers
    ) {
        return TransactionResponseDto.builder()
                .purchase(PurchaseMapper.toResponseDto(purchase))
                .sales(sales.stream().map(SaleMapper::toResponseDto).collect(Collectors.toList()))
                .billSummary(BillSummaryMapper.toResponseDto(billSummary))
                .build();
    }
}
