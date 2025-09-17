package com.moha123live.gtk_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moha123live.gtk_api.model.BillSummary;

@Repository
public interface BillSummaryRepository extends JpaRepository<BillSummary, Integer>{
    
}
