package com.moha123live.gtk_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moha123live.gtk_api.model.Sale;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Integer>{
    
}
