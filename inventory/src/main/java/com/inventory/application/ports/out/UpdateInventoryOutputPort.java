package com.inventory.application.ports.out;


import com.inventory.application.core.domain.Inventory;

public interface UpdateInventoryOutputPort {

    void update(Inventory inventory);

}
