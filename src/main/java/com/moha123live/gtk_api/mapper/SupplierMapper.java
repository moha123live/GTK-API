package com.moha123live.gtk_api.mapper;

import com.moha123live.gtk_api.dto.requestDto.SupplierRequestDto;
import com.moha123live.gtk_api.dto.responseDto.SupplierResponseDto;
import com.moha123live.gtk_api.model.Supplier;

public class SupplierMapper {

    public static Supplier toEntity(SupplierRequestDto req){
        if (req == null) return null;
        Supplier customer = new Supplier();
            customer.setName(req.getName());
            customer.setAddress(req.getAddress());
            customer.setCity(req.getCity());
            customer.setPhone(req.getPhone());
            customer.setBalanceDue(req.getBalanceDue());
            if (req.getStatus() != null) {
                customer.setStatus(Supplier.Status.valueOf(req.getStatus().toUpperCase()));
            }
        return customer;
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
