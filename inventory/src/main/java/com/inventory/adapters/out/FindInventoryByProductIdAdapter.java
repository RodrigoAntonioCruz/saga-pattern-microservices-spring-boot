package com.inventory.adapters.out;


import com.inventory.adapters.out.repository.InventoryRepository;
import com.inventory.adapters.out.repository.mapper.InventoryEntityMapper;
import com.inventory.application.core.domain.Inventory;
import com.inventory.application.ports.out.FindInventoryByProductIdOutputPort;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class FindInventoryByProductIdAdapter implements FindInventoryByProductIdOutputPort {

    private final InventoryRepository inventoryRepository;

    private final InventoryEntityMapper inventoryEntityMapper;

    @Override
    public Optional<Inventory> find(String productId) {
        var inventoryEntity = inventoryRepository.findByProductId(productId);
        return inventoryEntity.map(inventoryEntityMapper::toInventory);
    }

}
