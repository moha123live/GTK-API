package com.moha123live.gtk_api.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moha123live.gtk_api.model.Purchase;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Integer> {

    Optional<Purchase> findByDateAndSupplier_SupIdAndProduct_prodId(LocalDate date, Integer supId, Integer prodId);

    Optional<Purchase> findByDateAndBillNoAndProduct_prodId(LocalDate date, String billNo, Integer prodId);

}
