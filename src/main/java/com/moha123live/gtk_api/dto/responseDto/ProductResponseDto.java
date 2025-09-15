package com.moha123live.gtk_api.dto.responseDto;

import java.math.BigDecimal;

import lombok.*;

@Data
@Builder
public class ProductResponseDto {
    private Integer id;
    private String name;
    private String tamilName;
    private String unit;
    private BigDecimal comm2;
    private String status;
}
