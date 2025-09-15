package com.moha123live.gtk_api.controller;

import org.springframework.web.bind.annotation.RestController;

import com.moha123live.gtk_api.dto.requestDto.ProductRequestDto;
import com.moha123live.gtk_api.dto.responseDto.ApiResponse;
import com.moha123live.gtk_api.dto.responseDto.ProductResponseDto;
import com.moha123live.gtk_api.service.ProductService;
import com.moha123live.gtk_api.util.ApiResponseUtil;
import com.moha123live.gtk_api.util.AppMessages;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<ProductResponseDto>>> getAllProducts() {
        List<ProductResponseDto> response = productService.getAllProducts();
        return ResponseEntity.ok(ApiResponseUtil.success(AppMessages.PRODUCTS_FETCHED, response));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ProductResponseDto>> getProductById(@PathVariable Integer id) {
        ProductResponseDto response = productService.getProductById(id);
        return ResponseEntity.ok(ApiResponseUtil.success(AppMessages.PRODUCT_FETCHED,response));
    }

    @GetMapping("/search")
    public ResponseEntity<ApiResponse<List<ProductResponseDto>>> searchProductsByName(@RequestParam String name) {
        List<ProductResponseDto> response = productService.getProductsByName(name);
        return ResponseEntity.ok(ApiResponseUtil.success(AppMessages.PRODUCTS_FETCHED,response));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<ProductResponseDto>> createProduct(@Valid @RequestBody ProductRequestDto product) {
        ProductResponseDto response = productService.createProduct(product);
        return ResponseEntity.ok(ApiResponseUtil.success(AppMessages.PRODUCT_CREATED,response));
    }

    @PostMapping("/bulk")
    public ResponseEntity<ApiResponse<List<ProductResponseDto>>> createAllProducts(@Valid @RequestBody List<ProductRequestDto> products) {
        List<ProductResponseDto> response = productService.createAllProducts(products);
        return ResponseEntity.ok(ApiResponseUtil.success(AppMessages.PRODUCT_ALL_CREATED,response));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<ProductResponseDto>> updateProduct(@PathVariable Integer id, @Valid @RequestBody ProductRequestDto product) {
        ProductResponseDto response = productService.updateProduct(product,id);
        return ResponseEntity.ok(ApiResponseUtil.success(AppMessages.PRODUCT_UPDATED,response));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteProduct(@PathVariable Integer id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok(ApiResponseUtil.success(AppMessages.PRODUCT_DELETED, null));
    }

    @GetMapping("/{id}/ledger")
    public ResponseEntity<ApiResponse<String>> getProductLedger(@PathVariable Integer id) {
        // Placeholder; later integrate Ledger service
        return ResponseEntity.ok(ApiResponseUtil.success("Ledger for product ID: " + id, null));
    }


}
