package com.moha123live.gtk_api.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moha123live.gtk_api.model.SaleItem;

@Repository
public interface SaleItemRepository extends JpaRepository<SaleItem, BigInteger> {

}
