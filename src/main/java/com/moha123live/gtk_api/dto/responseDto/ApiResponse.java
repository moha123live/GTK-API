package com.moha123live.gtk_api.dto.responseDto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApiResponse<T> {
    private int statusCode;
    private String status;
    private String message;
    private T data;
}
