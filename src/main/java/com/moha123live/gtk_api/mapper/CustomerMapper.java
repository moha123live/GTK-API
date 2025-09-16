package com.moha123live.gtk_api.mapper;

import com.moha123live.gtk_api.dto.requestDto.CustomerRequestDto;
import com.moha123live.gtk_api.dto.responseDto.CustomerResponseDto;
import com.moha123live.gtk_api.model.Customer;

public class CustomerMapper {

    public static Customer toEntity(CustomerRequestDto req) {
        if (req == null) return null;
        Customer customer = new Customer();
        customer.setName(req.getName());
        customer.setTamilName(req.getTamilName());
        customer.setAddress(req.getAddress());
        customer.setCity(req.getCity());
        customer.setPhone(req.getPhone());
        customer.setOldBalance(req.getOldBalance());
        customer.setCurrBalance(req.getCurrBalance());
        customer.setComm1(req.getComm1());
        if (req.getStatus() != null) {
            customer.setStatus(req.getStatus());
        }
        return customer;
    }

    public static CustomerResponseDto toResponseDto(Customer res) {
        if (res == null) return null;
        return CustomerResponseDto.builder()
                .id(res.getCusId())
                .name(res.getName())
                .tamilName(res.getTamilName())
                .address(res.getAddress())
                .city(res.getCity())
                .phone(res.getPhone())
                .oldBalance(res.getOldBalance())
                .currBalance(res.getCurrBalance())
                .comm1(res.getComm1())
                .status(res.getStatus().name())
                .build();
    }

}
