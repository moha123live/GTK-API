package com.moha123live.gtk_api.dto.requestDto;

import java.math.BigDecimal;
import com.moha123live.gtk_api.model.Product;
import com.moha123live.gtk_api.util.AppMessages;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ProductRequestDto {

    @NotBlank(message = AppMessages.PRODUCT_NAME_REQUIRED)
    @Size(max = 100, message = AppMessages.PRODUCT_NAME_LENGTH)
    private String name;

    @Size(max = 100, message = AppMessages.PRODUCT_TAMIL_NAME_LENGTH)
    private String tamilName;

    @NotNull(message = AppMessages.PRODUCT_UNIT_REQUIRED)
    private Product.Unit unit;

    @DecimalMin(value = "0.00", inclusive = true, message = AppMessages.PRODUCT_COMMISSION_GREATER_THAN_ZERO)
    private BigDecimal comm2;

    private Product.Status status;

}
