package com.moha123live.gtk_api.controller;

import com.moha123live.gtk_api.dto.requestDto.TransactionRequestDto;
import com.moha123live.gtk_api.dto.responseDto.ApiResponse;
import com.moha123live.gtk_api.dto.responseDto.TransactionResponseDto;
import com.moha123live.gtk_api.service.TransactionService;
import com.moha123live.gtk_api.util.ApiResponseUtil;
import com.moha123live.gtk_api.util.AppMessages;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/purchase-bill")
    public ResponseEntity<ApiResponse<TransactionResponseDto>> createTransaction(@Valid @RequestBody TransactionRequestDto request) {
        TransactionResponseDto response = transactionService.createTransaction(request);
        return ResponseEntity.ok(ApiResponseUtil.success(AppMessages.BILL_ADDED, response));
    }
}
