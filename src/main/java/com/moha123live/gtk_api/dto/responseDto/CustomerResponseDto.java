package com.moha123live.gtk_api.dto.responseDto;

import java.math.BigDecimal;

import lombok.*;

@Data
@Builder
public class CustomerResponseDto {
    private Integer id;
    private String name;
    private String tamilName;
    private String address;
    private String city;
    private String phone;
    private BigDecimal oldBalance;
    private BigDecimal currBalance;
    private BigDecimal comm1;
    private String status;
}
