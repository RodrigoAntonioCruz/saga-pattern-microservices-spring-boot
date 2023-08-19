package com.inventory.adapters.out.repository;


import com.inventory.adapters.out.repository.entity.InventoryEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InventoryRepository extends MongoRepository<InventoryEntity, String> {

    Optional<InventoryEntity> findByProductId(String productId);

}
