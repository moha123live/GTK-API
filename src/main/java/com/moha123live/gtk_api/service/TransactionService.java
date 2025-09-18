package com.moha123live.gtk_api.service;

import com.moha123live.gtk_api.dto.requestDto.TransactionRequestDto;
import com.moha123live.gtk_api.dto.responseDto.TransactionResponseDto;

public interface TransactionService {
    TransactionResponseDto createTransaction(TransactionRequestDto request);
//     TransactionResponseDto update(Long purchaseId, TransactionRequestDto request);
//     void delete(Long purchaseId);
//     TransactionResponseDto getById(Long purchaseId);
}
