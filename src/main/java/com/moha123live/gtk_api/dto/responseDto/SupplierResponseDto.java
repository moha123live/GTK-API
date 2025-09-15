package com.moha123live.gtk_api.dto.responseDto;

import java.math.BigDecimal;

import lombok.*;

@Data
@Builder
public class SupplierResponseDto {
    private Integer id;
    private String name;
    private String address;
    private String city;
    private String phone;
    private BigDecimal balanceDue;
    private String status;
}
