package com.moha123live.gtk_api.service;

import com.moha123live.gtk_api.dto.requestDto.TransactionRequestDto;
import com.moha123live.gtk_api.dto.responseDto.TransactionResponseDto;

public interface TransactionService {

    TransactionResponseDto createTransaction(TransactionRequestDto request);

    TransactionResponseDto updateTransaction(Integer id, TransactionRequestDto request);

    void deleteTransaction(Integer id);

    TransactionResponseDto getTransactionById(Integer id);

    TransactionResponseDto getTransactionBySearch(TransactionRequestDto.Search request);

    TransactionResponseDto getTransactionBySearchBillNo(TransactionRequestDto.SearchBillNo request);
    
}
