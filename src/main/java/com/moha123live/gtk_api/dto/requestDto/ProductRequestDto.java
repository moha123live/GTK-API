package com.moha123live.gtk_api.dto.requestDto;

import com.moha123live.gtk_api.model.Product;
import com.moha123live.gtk_api.util.AppMessages;
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

    private Product.Status status;

}
