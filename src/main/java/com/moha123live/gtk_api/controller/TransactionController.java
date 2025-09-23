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

    @PutMapping("/purchase-bill/{id}")
    public ResponseEntity<ApiResponse<TransactionResponseDto>> updateTransaction(@PathVariable Integer id, @Valid @RequestBody TransactionRequestDto request) {
        TransactionResponseDto response = transactionService.updateTransaction(id, request);
        return ResponseEntity.ok(ApiResponseUtil.success(AppMessages.BILL_UPDATED, response));
    }

    @DeleteMapping("/purchase-bill/{id}")
    public ResponseEntity<ApiResponse<TransactionResponseDto>> updateTransaction(@PathVariable Integer id) {
        transactionService.deleteTransaction(id);
        return ResponseEntity.ok(ApiResponseUtil.success(AppMessages.BILL_DELETED, null));
    }

    @GetMapping("/purchase-bill/{id}")
    public ResponseEntity<ApiResponse<TransactionResponseDto>> getTransactionById(@PathVariable Integer id) {
        TransactionResponseDto response = transactionService.getTransactionById(id);
        return ResponseEntity.ok(ApiResponseUtil.success(AppMessages.BILL_FETCHED, response));
    }

    @GetMapping("/purchase-bill/search")
    public ResponseEntity<ApiResponse<TransactionResponseDto>> getTransactionBySearch(@Valid @RequestBody TransactionRequestDto.Search request) {
        TransactionResponseDto response = transactionService.getTransactionBySearch(request);
        return ResponseEntity.ok(ApiResponseUtil.success(AppMessages.BILL_FETCHED, response));
    }

    @GetMapping("/purchase-bill/searchBillNo")
    public ResponseEntity<ApiResponse<TransactionResponseDto>> getTransactionBySearchBillNo(@Valid @RequestBody TransactionRequestDto.SearchBillNo request) {
        TransactionResponseDto response = transactionService.getTransactionBySearchBillNo(request);
        return ResponseEntity.ok(ApiResponseUtil.success(AppMessages.BILL_FETCHED, response));
    }
}
