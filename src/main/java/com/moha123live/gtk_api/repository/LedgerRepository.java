package com.moha123live.gtk_api.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moha123live.gtk_api.model.Ledger;
import com.moha123live.gtk_api.model.Ledger.EntityType;
import com.moha123live.gtk_api.model.Ledger.ReferenceType;

@Repository
public interface LedgerRepository extends JpaRepository<Ledger, Integer>{

    Optional<Ledger> findByDateAndReferenceTypeAndEntityTypeAndEntityId(LocalDate atStartOfDay, ReferenceType purchase, EntityType supplier,
            Integer supId);
}
