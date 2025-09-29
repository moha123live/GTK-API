package com.moha123live.gtk_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moha123live.gtk_api.model.Supplier;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Integer> {
    List<Supplier> findByNameContainingIgnoreCase(String name);

    boolean existsByNameIgnoreCase(String name);

}
