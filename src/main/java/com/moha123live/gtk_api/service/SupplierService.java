package com.moha123live.gtk_api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.moha123live.gtk_api.dto.requestDto.SupplierRequestDto;
import com.moha123live.gtk_api.dto.responseDto.SupplierResponseDto;
import com.moha123live.gtk_api.mapper.SupplierMapper;
import com.moha123live.gtk_api.model.Supplier;
import com.moha123live.gtk_api.repository.SupplierRepository;
import com.moha123live.gtk_api.util.AppMessages;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    public List<SupplierResponseDto> getAllSuppliers() {
        List<Supplier> suppliers= supplierRepository.findAll();
        List<SupplierResponseDto> responseList = new ArrayList<>();
        for(Supplier supplier : suppliers){
            responseList.add(SupplierMapper.toResponseDto(supplier));
        }
        return responseList;
    }

    public SupplierResponseDto getSupplierById(Integer id) {
        Supplier supplier = supplierRepository.findById(id).orElseThrow(() -> new NoSuchElementException(AppMessages.SUPPLIER_NOT_FOUND));
        SupplierResponseDto response = SupplierMapper.toResponseDto(supplier);
        return response;
    }

    public SupplierResponseDto createSupplier(SupplierRequestDto request) {
        if (supplierRepository.existsByNameIgnoreCase(request.getName())) {
            throw new IllegalArgumentException(request.getName() + " - " + AppMessages.SUPPLIER_ALREADY_EXISTS);
        }
        Supplier supplier = SupplierMapper.toEntity(request);
        Supplier data = supplierRepository.save(supplier);
        return SupplierMapper.toResponseDto(data);
    }

    public SupplierResponseDto updateSupplier(SupplierRequestDto request,Integer id) {
        supplierRepository.findById(id).orElseThrow(() -> new NoSuchElementException(AppMessages.PRODUCT_NOT_FOUND));
        Supplier supplier = SupplierMapper.toEntity(request);
        supplier.setSupId(id);
        Supplier data = supplierRepository.save(supplier);
        return SupplierMapper.toResponseDto(data);
    }

    public void deleteSupplier(int id) {
        Supplier supplier = supplierRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(AppMessages.SUPPLIER_ALREADY_EXISTS));
        supplier.setIsDeleted(true);
        supplierRepository.save(supplier);
    }

    public List<SupplierResponseDto> getSuppliersByName(String name) {
        List<Supplier> suppliers = supplierRepository.findByNameContainingIgnoreCase(name);
        List<SupplierResponseDto> responseList = new ArrayList<>();
        for (Supplier supplier : suppliers) {
            responseList.add(SupplierMapper.toResponseDto(supplier));
        }
        return responseList;
    }

    public List<SupplierResponseDto> createAllSuppliers(List<SupplierRequestDto> requests) {
        List<Supplier> suppliersToSave = new ArrayList<>();
        for (SupplierRequestDto request : requests) {
            if (supplierRepository.existsByNameIgnoreCase(request.getName())) {
                throw new IllegalArgumentException(
                        request.getName() + " - " + AppMessages.SUPPLIER_ALREADY_EXISTS
                );
            }
            Supplier supplier = SupplierMapper.toEntity(request);
            suppliersToSave.add(supplier);
        }
        List<Supplier> savedSuppliers = supplierRepository.saveAll(suppliersToSave);
        List<SupplierResponseDto> responseList = new ArrayList<>();
        for (Supplier supplier : savedSuppliers) {
            responseList.add(SupplierMapper.toResponseDto(supplier));
        }
        return responseList;
    }
}
