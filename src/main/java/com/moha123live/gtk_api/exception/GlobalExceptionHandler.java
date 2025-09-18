package com.moha123live.gtk_api.exception;

import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.lang.IllegalArgumentException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.moha123live.gtk_api.dto.responseDto.ApiResponse;
import com.moha123live.gtk_api.util.ApiResponseUtil;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Object>> handleAllException(Exception ex) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

        if(ex instanceof NoSuchElementException || ex instanceof NoHandlerFoundException) {
            status = HttpStatus.NOT_FOUND;
        } else if (ex instanceof IllegalArgumentException || ex instanceof MethodArgumentTypeMismatchException || ex instanceof MethodArgumentNotValidException ){
            status = HttpStatus.BAD_REQUEST;
        }

        String message =  ex instanceof NoHandlerFoundException ? "Endpoint not found" : ex.getMessage();
        if(ex instanceof MethodArgumentNotValidException){
            MethodArgumentNotValidException validationEx = (MethodArgumentNotValidException) ex;
            message = validationEx.getBindingResult().getFieldErrors().stream()
                    .map(err -> err.getDefaultMessage())
                    .collect(Collectors.joining(", "));

        }
        return ResponseEntity.status(status).body(ApiResponseUtil.error(message, status));

    }
}
