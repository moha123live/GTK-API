package com.moha123live.gtk_api.mapper;

import java.time.LocalDate;

import com.moha123live.gtk_api.dto.requestDto.PurchaseRequestDto;
import com.moha123live.gtk_api.dto.responseDto.PurchaseResponseDto;
import com.moha123live.gtk_api.model.Product;
import com.moha123live.gtk_api.model.Purchase;
import com.moha123live.gtk_api.model.Supplier;

public class PurchaseMapper {

    public static Purchase toEntity(PurchaseRequestDto req, Supplier supplier, Product product) {
        if (req == null) return null;

        return Purchase.builder()
                .supplier(supplier)
                .product(product)
                .billNo(req.getBillNo())
                .date(req.getDate() != null ? req.getDate() : LocalDate.now())
                .rate(req.getRate())
                .qty(req.getQty())
                .weight(req.getWeight())
                .amount(req.getAmount())
                .build();
    }

    public static PurchaseResponseDto toResponseDto(Purchase res) {
        if (res == null) return null;

        return PurchaseResponseDto.builder()
                .id(res.getPurId())
                .billNo(res.getBillNo())
                .date(res.getDate())
                .rate(res.getRate())
                .qty(res.getQty())
                .weight(res.getWeight())
                .amount(res.getAmount())
                .supId(res.getSupplier().getSupId())
                .supName(res.getSupplier().getName())
                .productId(res.getProduct().getProductId())
                .productName(res.getProduct().getName())
                .build();
    }
}
