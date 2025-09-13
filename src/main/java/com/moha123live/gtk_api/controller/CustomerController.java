package com.moha123live.gtk_api.controller;

import org.springframework.web.bind.annotation.RestController;

import com.moha123live.gtk_api.dto.requestDto.CustomerRequestDto;
import com.moha123live.gtk_api.dto.responseDto.ApiResponse;
import com.moha123live.gtk_api.dto.responseDto.CustomerResponseDto;
import com.moha123live.gtk_api.model.Customer;
import com.moha123live.gtk_api.service.CustomerService;
import com.moha123live.gtk_api.util.ApiResponseUtil;
import com.moha123live.gtk_api.util.AppMessages;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<CustomerResponseDto>>> getAllCustomers() {
        List<CustomerResponseDto> response = customerService.getAllCustomers();
        return ResponseEntity.ok(ApiResponseUtil.success(AppMessages.CUSTOMERS_FETCHED, response));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<CustomerResponseDto>> getCustomerById(@PathVariable Integer id) {
        CustomerResponseDto response = customerService.getCustomerById(id);
        return ResponseEntity.ok(ApiResponseUtil.success(AppMessages.CUSTOMER_FETCHED,response));
    }

    @GetMapping("/search")
    public ResponseEntity<ApiResponse<List<CustomerResponseDto>>> searchCustomersByName(@RequestParam String name) {
        List<CustomerResponseDto> response = customerService.getCustomersByName(name);
        return ResponseEntity.ok(ApiResponseUtil.success(AppMessages.CUSTOMER_FETCHED,response));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<CustomerResponseDto>> createCustomer(@Valid @RequestBody CustomerRequestDto customer) {
        CustomerResponseDto response = customerService.createCustomer(customer);
        return ResponseEntity.ok(ApiResponseUtil.success(AppMessages.CUSTOMER_CREATED,response));
    }

    @PostMapping("/bulk")
    public ResponseEntity<ApiResponse<List<CustomerResponseDto>>> createAllCustomer(@Valid @RequestBody List<CustomerRequestDto> customers) {
        List<CustomerResponseDto> response = customerService.createAllCustomers(customers);
        return ResponseEntity.ok(ApiResponseUtil.success(AppMessages.CUSTOMER_ALL_CREATED,response));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<CustomerResponseDto>> updateCustomer(@PathVariable Integer id, @Valid @RequestBody CustomerRequestDto customer) {
        CustomerResponseDto response = customerService.updateCustomer(customer,id);
        return ResponseEntity.ok(ApiResponseUtil.success(AppMessages.CUSTOMER_UPDATED,response));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteCustomer(@PathVariable Integer id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.ok(ApiResponseUtil.success(AppMessages.CUSTOMER_DELETED, null));
    }

    @GetMapping("/{id}/ledger")
    public ResponseEntity<ApiResponse<String>> getCustomerLedger(@PathVariable Integer id) {
        // Placeholder; later integrate Ledger service
        return ResponseEntity.ok(ApiResponseUtil.success("Ledger for customer ID: " + id, null));
    }


}
