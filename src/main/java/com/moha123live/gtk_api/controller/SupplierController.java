package com.moha123live.gtk_api.controller;

import com.moha123live.gtk_api.dto.requestDto.SupplierRequestDto;
import com.moha123live.gtk_api.dto.responseDto.ApiResponse;
import com.moha123live.gtk_api.dto.responseDto.SupplierResponseDto;
import com.moha123live.gtk_api.service.SupplierService;
import com.moha123live.gtk_api.util.ApiResponseUtil;
import com.moha123live.gtk_api.util.AppMessages;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/suppliers")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<SupplierResponseDto>>> getAllSuppliers() {
        List<SupplierResponseDto> response = supplierService.getAllSuppliers();
        return ResponseEntity.ok(ApiResponseUtil.success(AppMessages.SUPPLIERS_FETCHED, response));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<SupplierResponseDto>> getSupplierById(@PathVariable Integer id) {
        SupplierResponseDto response = supplierService.getSupplierById(id);
        return ResponseEntity.ok(ApiResponseUtil.success(AppMessages.SUPPLIER_FETCHED,response));
    }

    @GetMapping("/search")
    public ResponseEntity<ApiResponse<List<SupplierResponseDto>>> searchSuppliersByName(@RequestParam String name) {
        List<SupplierResponseDto> response = supplierService.getSuppliersByName(name);
        return ResponseEntity.ok(ApiResponseUtil.success(AppMessages.SUPPLIERS_FETCHED,response));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<SupplierResponseDto>> createSupplier(@Valid @RequestBody SupplierRequestDto supplier) {
        SupplierResponseDto response = supplierService.createSupplier(supplier);
        return ResponseEntity.ok(ApiResponseUtil.success(AppMessages.SUPPLIER_CREATED,response));
    }

    @PostMapping("/bulk")
    public ResponseEntity<ApiResponse<List<SupplierResponseDto>>> createAllSupplier(@Valid @RequestBody List<SupplierRequestDto> suppliers) {
        List<SupplierResponseDto> response = supplierService.createAllSuppliers(suppliers);
        return ResponseEntity.ok(ApiResponseUtil.success(AppMessages.SUPPLIER_ALL_CREATED,response));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<SupplierResponseDto>> updateSupplier(@PathVariable Integer id, @Valid @RequestBody SupplierRequestDto supplier) {
        SupplierResponseDto response = supplierService.updateSupplier(supplier,id);
        return ResponseEntity.ok(ApiResponseUtil.success(AppMessages.SUPPLIER_UPDATED,response));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteSupplier(@PathVariable Integer id) {
        supplierService.deleteSupplier(id);
        return ResponseEntity.ok(ApiResponseUtil.success(AppMessages.SUPPLIER_DELETED, null));
    }

    @GetMapping("/{id}/ledger")
    public ResponseEntity<ApiResponse<String>> getSupplierLedger(@PathVariable Integer id) {
        // Placeholder; later integrate Ledger service
        return ResponseEntity.ok(ApiResponseUtil.success("Ledger for supplier ID: " + id, null));
    }


}
