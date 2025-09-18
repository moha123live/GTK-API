package com.moha123live.gtk_api.mapper;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.moha123live.gtk_api.dto.requestDto.PurchaseRequestDto;
import com.moha123live.gtk_api.dto.responseDto.PurchaseResponseDto;
import com.moha123live.gtk_api.model.Product;
import com.moha123live.gtk_api.model.Purchase;
import com.moha123live.gtk_api.model.Supplier;
import com.moha123live.gtk_api.repository.ProductRepository;
import com.moha123live.gtk_api.repository.SupplierRepository;
import com.moha123live.gtk_api.util.AppMessages;

@Component
public class PurchaseMapper {

    @Autowired
    private SupplierRepository supplierRepository;
    @Autowired
    private ProductRepository productRepository;

    public Purchase toEntity(PurchaseRequestDto dto) {
        if (dto == null) return null;

        Supplier supplier = supplierRepository.findById(dto.getSupId())
                .orElseThrow(() -> new RuntimeException(AppMessages.SUPPLIER_NOT_FOUND));

        Product product = productRepository.findById(dto.getProductId())
                .orElseThrow(() -> new RuntimeException(AppMessages.PRODUCT_NOT_FOUND));

        return Purchase.builder()
                .supplier(supplier)
                .product(product)
                .billNo(dto.getBillNo())
                .date(dto.getDate() != null ? dto.getDate() : LocalDate.now())
                .rate(dto.getRate())
                .qty(dto.getQty())
                .weight(dto.getWeight())
                .amount(dto.getAmount())
                .build();
    }

    public PurchaseResponseDto toResponseDto(Purchase entity) {
        if (entity == null) return null;

        return PurchaseResponseDto.builder()
                .id(entity.getPurId())
                .billNo(entity.getBillNo())
                .date(entity.getDate())
                .rate(entity.getRate())
                .qty(entity.getQty())
                .weight(entity.getWeight())
                .amount(entity.getAmount())
                .supplierName(entity.getSupplier().getName())
                .productName(entity.getProduct().getName())
                .build();
    }
}
