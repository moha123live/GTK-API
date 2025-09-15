package com.moha123live.gtk_api.mapper;

import com.moha123live.gtk_api.dto.requestDto.SupplierRequestDto;
import com.moha123live.gtk_api.dto.responseDto.SupplierResponseDto;
import com.moha123live.gtk_api.model.Supplier;

public class SupplierMapper {

    public static Supplier toEntity(SupplierRequestDto req){
        if (req == null) return null;
        Supplier supplier = new Supplier();
            supplier.setName(req.getName());
            supplier.setAddress(req.getAddress());
            supplier.setCity(req.getCity());
            supplier.setPhone(req.getPhone());
            supplier.setBalanceDue(req.getBalanceDue());
            if (req.getStatus() != null) {
                supplier.setStatus(req.getStatus());
            }
        return supplier;
    }

    public static SupplierResponseDto toResponseDto(Supplier res){
        if(res == null) return null;
        return SupplierResponseDto.builder()
            .id(res.getSupId())
            .name(res.getName())
            .address(res.getAddress())
            .city(res.getCity())
            .phone(res.getPhone())
            .balanceDue(res.getBalanceDue())
            .status(res.getStatus().name())
            .build();
    }

}
