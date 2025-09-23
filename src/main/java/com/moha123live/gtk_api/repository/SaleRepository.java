package com.moha123live.gtk_api.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.moha123live.gtk_api.model.Sale;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Integer> {

    List<Sale> findByPurchase_PurId(Integer id);
    void deleteByPurchase_PurId(Integer id);

}
