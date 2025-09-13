package com.moha123live.gtk_api.util;

import org.springframework.http.HttpStatus;

import com.moha123live.gtk_api.dto.responseDto.ApiResponse;

public class ApiResponseUtil {

    public static <T> ApiResponse<T> success(String message, T data) {
        return success(message, data, HttpStatus.OK);
    }

    public static <T> ApiResponse<T> success(String message, T data, HttpStatus statusCode) {

        return ApiResponse.<T>builder()
                .status(AppMessages.SUCCESS)
                .statusCode(statusCode.value())
                .message(message)
                .data(data)
                .build();
    }

    public static <T> ApiResponse<T> error(String message) {
        return error(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public static <T> ApiResponse<T> error(String message, HttpStatus statusCode) {

        return ApiResponse.<T>builder()
                .status(AppMessages.ERROR)
                .statusCode(statusCode.value())
                .message(message)
                .data(null)
                .build();
    }
}
