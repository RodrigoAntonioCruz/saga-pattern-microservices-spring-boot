package com.inventory.application.core.usecase;


import com.inventory.application.core.domain.Inventory;
import com.inventory.application.ports.in.FindInventoryByProductIdInputPort;
import com.inventory.application.ports.out.FindInventoryByProductIdOutputPort;

public class FindInventoryByProductIdUseCase implements FindInventoryByProductIdInputPort {

    private final FindInventoryByProductIdOutputPort findInventoryByProductIdOutputPort;

    public FindInventoryByProductIdUseCase(
            FindInventoryByProductIdOutputPort findInventoryByProductIdOutputPort
    ) {
        this.findInventoryByProductIdOutputPort = findInventoryByProductIdOutputPort;
    }

    @Override
    public Inventory find(String productId) {
        return findInventoryByProductIdOutputPort.find(productId)
                .orElseThrow(() -> new RuntimeException("Estoque não encontrado para este produto!"));
    }
}
