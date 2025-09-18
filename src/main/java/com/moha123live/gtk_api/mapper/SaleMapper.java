package com.moha123live.gtk_api.mapper;

import com.moha123live.gtk_api.dto.requestDto.SaleRequestDto;
import com.moha123live.gtk_api.dto.responseDto.SaleResponseDto;
import com.moha123live.gtk_api.model.Customer;
import com.moha123live.gtk_api.model.Purchase;
import com.moha123live.gtk_api.model.Sale;

import java.math.BigDecimal;
public class SaleMapper {

    public static Sale toEntity(SaleRequestDto req, Purchase purchase, Customer customer) {
        if (req == null) return null;
        return Sale.builder()
                .purchase(purchase)
                .date(req.getDate())
                .customer(customer)
                .qty(req.getQty())
                .bagWeight(req.getBagWeight())
                .weight(req.getWeight())
                .bagRate(req.getBagRate())
                .commission(req.getCommission() != null ? req.getCommission() : BigDecimal.ZERO)
                .rate(req.getRate())
                .amount(req.getAmount())
                .netAmount(req.getNetAmount())
                .build();
    }

    public static SaleResponseDto toResponseDto(Sale res) {
        if (res == null) return null;

        return SaleResponseDto.builder()
                .saleId(res.getSaleId())
                .date(res.getDate())
                .customerId(res.getCustomer().getCusId())
                .customerName(res.getCustomer().getName())
                .qty(res.getQty())
                .bagWeight(res.getBagWeight())
                .weight(res.getWeight())
                .bagRate(res.getBagRate())
                .commission(res.getCommission())
                .rate(res.getRate())
                .amount(res.getAmount())
                .netAmount(res.getNetAmount())
                .build();
    }
}
