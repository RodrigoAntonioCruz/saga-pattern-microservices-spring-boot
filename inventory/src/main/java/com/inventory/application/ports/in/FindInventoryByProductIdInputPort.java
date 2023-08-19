package com.inventory.application.ports.in;


import com.inventory.application.core.domain.Inventory;

public interface FindInventoryByProductIdInputPort {

    Inventory find(String productId);

}
