package com.inventory.adapters.out;


import com.inventory.adapters.out.repository.InventoryRepository;
import com.inventory.adapters.out.repository.mapper.InventoryEntityMapper;
import com.inventory.application.core.domain.Inventory;
import com.inventory.application.ports.out.UpdateInventoryOutputPort;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UpdateInventoryAdapter implements UpdateInventoryOutputPort {

    private final InventoryRepository inventoryRepository;

    private final InventoryEntityMapper inventoryEntityMapper;

    @Override
    public void update(Inventory inventory) {
        var inventoryEntity = inventoryEntityMapper.toInventoryEntity(inventory);
        inventoryRepository.save(inventoryEntity);
    }
}
