package com.moha123live.gtk_api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.moha123live.gtk_api.dto.requestDto.ProductRequestDto;
import com.moha123live.gtk_api.dto.responseDto.ProductResponseDto;
import com.moha123live.gtk_api.mapper.ProductMapper;
import com.moha123live.gtk_api.model.Product;
import com.moha123live.gtk_api.repository.ProductRepository;
import com.moha123live.gtk_api.util.AppMessages;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductResponseDto> getAllProducts() {
        List<Product> products= productRepository.findAll();
        List<ProductResponseDto> responseList = new ArrayList<>();
        for(Product product : products){
            responseList.add(ProductMapper.toResponseDto(product));
        }
        return responseList;
    }

    public ProductResponseDto getProductById(Integer id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new NoSuchElementException(AppMessages.PRODUCT_NOT_FOUND));
        ProductResponseDto response = ProductMapper.toResponseDto(product);
        return response;
    }

    public ProductResponseDto createProduct(ProductRequestDto request) {
        if (productRepository.existsByNameIgnoreCase(request.getName())) {
            throw new IllegalArgumentException(request.getName() + " - " + AppMessages.PRODUCT_ALREADY_EXISTS);
        }
        Product product = ProductMapper.toEntity(request);
        Product data = productRepository.save(product);
        return ProductMapper.toResponseDto(data);
    }

    public ProductResponseDto updateProduct(ProductRequestDto request,Integer id) {
        productRepository.findById(id).orElseThrow(() -> new NoSuchElementException(AppMessages.PRODUCT_NOT_FOUND));
        Product product = ProductMapper.toEntity(request);
        product.setProdId(id);
        Product data = productRepository.save(product);
        return ProductMapper.toResponseDto(data);
    }

    public void deleteProduct(int id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(AppMessages.PRODUCT_ALREADY_EXISTS));
        product.setIsDeleted(true);
        productRepository.save(product);
    }

    public List<ProductResponseDto> getProductsByName(String name) {
        List<Product> products = productRepository.findByNameContainingIgnoreCase(name);
        List<ProductResponseDto> responseList = new ArrayList<>();
        for (Product product : products) {
            responseList.add(ProductMapper.toResponseDto(product));
        }
        return responseList;
    }

    public List<ProductResponseDto> createAllProducts(List<ProductRequestDto> requests) {
        List<Product> productsToSave = new ArrayList<>();
        for (ProductRequestDto request : requests) {
            if (productRepository.existsByNameIgnoreCase(request.getName())) {
                throw new IllegalArgumentException(
                        request.getName() + " - " + AppMessages.PRODUCT_ALREADY_EXISTS
                );
            }
            Product product = ProductMapper.toEntity(request);
            productsToSave.add(product);
        }
        List<Product> savedProducts = productRepository.saveAll(productsToSave);
        List<ProductResponseDto> responseList = new ArrayList<>();
        for (Product product : savedProducts) {
            responseList.add(ProductMapper.toResponseDto(product));
        }
        return responseList;
    }
}
