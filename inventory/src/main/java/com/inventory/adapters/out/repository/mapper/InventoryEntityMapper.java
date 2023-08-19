package com.inventory.adapters.out.repository.mapper;


import com.inventory.adapters.out.repository.entity.InventoryEntity;
import com.inventory.application.core.domain.Inventory;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InventoryEntityMapper {

    Inventory toInventory(InventoryEntity inventoryEntity);

    InventoryEntity toInventoryEntity(Inventory inventory);

}
