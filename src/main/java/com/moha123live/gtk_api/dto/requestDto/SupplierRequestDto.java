package com.moha123live.gtk_api.dto.requestDto;

import java.math.BigDecimal;
import com.moha123live.gtk_api.model.Supplier;
import com.moha123live.gtk_api.util.AppMessages;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SupplierRequestDto {
    @NotBlank(message = AppMessages.SUPPLIER_NAME_REQUIRED)
    @Size(max = 100, message = AppMessages.SUPPLIER_NAME_LENGTH)
    private String name;

    @Size(max = 255, message = AppMessages.SUPPLIER_ADDRESS_LENGTH)
    private String address;

    @Size(max = 100, message = AppMessages.SUPPLIER_CITY_LENGTH)
    private String city;

    @Pattern(regexp = "^[0-9]{10}$", message = AppMessages.SUPPLIER_PHONE_PATTERN)
    private String phone;

    @DecimalMin(value = "0.00", inclusive = true, message = AppMessages.SUPPLIER_BALANCE_DUE_GREATER_THAN_ZERO)
    private BigDecimal balanceDue;

    private Supplier.Status status;

}
