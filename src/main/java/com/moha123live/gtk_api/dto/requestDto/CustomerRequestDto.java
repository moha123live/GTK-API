package com.moha123live.gtk_api.dto.requestDto;

import java.math.BigDecimal;
import com.moha123live.gtk_api.model.Customer;
import com.moha123live.gtk_api.util.AppMessages;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class CustomerRequestDto {

        @NotBlank(message = AppMessages.CUSTOMER_NAME_REQUIRED)
        @Size(max = 100, message = AppMessages.CUSTOMER_NAME_LENGTH)
        private String name;

        @Size(max = 100, message = AppMessages.CUSTOMER_TAMIL_NAME_LENGTH)
        private String tamilName;

        @Size(max = 255, message = AppMessages.CUSTOMER_ADDRESS_LENGTH)
        private String address;

        @Size(max = 100, message = AppMessages.CUSTOMER_CITY_LENGTH)
        private String city;

        @Pattern(regexp = "^[0-9]{10}$", message = AppMessages.CUSTOMER_PHONE_PATTERN)
        private String phone;

        @DecimalMin(value = "0.00", inclusive = true, message = AppMessages.CUSTOMER_OLDBALANCE_GREATER_THAN_ZERO)
        private BigDecimal oldBalance;

        @DecimalMin(value = "0.00", inclusive = true, message = AppMessages.CUSTOMER_CURRBALANCE_GREATER_THAN_ZERO)
        private BigDecimal currBalance;

        @DecimalMin(value = "0.00", inclusive = true, message = AppMessages.CUSTOMER_COMMISSION_GREATER_THAN_ZERO)
        private BigDecimal comm1;

        private Customer.Status status;

}
