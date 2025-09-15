package com.moha123live.gtk_api.dto.requestDto;

import java.math.BigDecimal;
import com.moha123live.gtk_api.model.Product;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ProductRequestDto {

    @NotBlank(message = "Product name is required")
    @Size(max = 100, message = "Name must not exceed 100 characters")
    private String name;

    @Size(max = 100, message = "Tamil name must not exceed 100 characters")
    private String tamilName;

    @NotNull(message = "Unit is required")
    private Product.Unit unit;

    @DecimalMin(value = "0.00", inclusive = true, message = "Commission must be >= 0")
    private BigDecimal comm2;

    private Product.Status status;

}
