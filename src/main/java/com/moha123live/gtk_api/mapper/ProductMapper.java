package com.moha123live.gtk_api.mapper;

import com.moha123live.gtk_api.dto.requestDto.ProductRequestDto;
import com.moha123live.gtk_api.dto.responseDto.ProductResponseDto;
import com.moha123live.gtk_api.model.Product;

public class ProductMapper {

    public static Product toEntity(ProductRequestDto req) {
        if (req == null) return null;
        Product product = new Product();
        product.setName(req.getName());
        product.setTamilName(req.getTamilName());
        if (req.getUnit() != null) {
            product.setUnit(req.getUnit());
        }
        if (req.getComm2() != null) {
            product.setComm2(req.getComm2());
        }
        if (req.getStatus() != null) {
            product.setStatus(req.getStatus());
        }
        return product;
    }

    public static ProductResponseDto toResponseDto(Product res) {
        if (res == null) return null;
        return ProductResponseDto.builder()
                .id(res.getProductId())
                .name(res.getName())
                .tamilName(res.getTamilName())
                .unit(res.getUnit().name())
                .comm2(res.getComm2())
                .status(res.getStatus().name())
                .build();
    }

}
