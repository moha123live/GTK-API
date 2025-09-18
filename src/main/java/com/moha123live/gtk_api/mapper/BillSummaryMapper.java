package com.moha123live.gtk_api.mapper;

import com.moha123live.gtk_api.dto.requestDto.BillSummaryRequestDto;
import com.moha123live.gtk_api.dto.responseDto.BillSummaryResponseDto;
import com.moha123live.gtk_api.model.BillSummary;
import com.moha123live.gtk_api.model.Purchase;
import org.springframework.stereotype.Component;

@Component
public class BillSummaryMapper {

    public BillSummary toEntity(BillSummaryRequestDto req, Purchase purchase) {
        if (req == null) return null;

        return BillSummary.builder()
                .purchase(purchase)
                .totalQty(req.getTotalQty())
                .totalBagWeight(req.getTotalBagWeight())
                .totalWeight(req.getTotalWeight())
                .totalAmount(req.getTotalAmount())
                .totalNetAmount(req.getTotalNetAmount())
                .build();
    }

    public BillSummaryResponseDto toResponseDto(BillSummary res) {
        if (res == null) return null;

        return BillSummaryResponseDto.builder()
                .billId(res.getBillId())
                .purchaseId(res.getPurchase().getPurId())
                .totalQty(res.getTotalQty())
                .totalBagWeight(res.getTotalBagWeight())
                .totalWeight(res.getTotalWeight())
                .totalAmount(res.getTotalAmount())
                .totalNetAmount(res.getTotalNetAmount())
                .build();
    }
}
