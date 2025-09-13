package com.moha123live.gtk_api.dto.requestDto;

import java.math.BigDecimal;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class CustomerRequestDto {

        @NotBlank(message = "Name is required")
        @Size(max = 100, message = "Name must not exceed 100 character")
        private String name;

        @Size(max =100)
        private String tamilName;

        @Size(max = 255)
        private String address;

        @Size(max = 100)
        private String city;

        @Pattern(regexp = "^[0-9]{10}$", message = "Phone must be 10 digits")
        private String phone;

        @DecimalMin(value = "0.00", inclusive = true, message = "Old balance must be greater than or equal to 0.00")
        private BigDecimal oldBalance;

        @DecimalMin(value = "0.00", inclusive = true, message = "Current balance must be greater than or equal to 0.00")
        private BigDecimal currBalance;

        @DecimalMin(value = "0.00", inclusive = true, message = "Commission 1 must be greater than or equal to 0.00")
        private BigDecimal comm1;

        private String status;
    
}
