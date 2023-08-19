package com.sale.adapters.out.repository;

import com.sale.adapters.out.repository.entity.SaleEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

;

@Repository
public interface SaleRepository extends MongoRepository<SaleEntity, String> {
}
