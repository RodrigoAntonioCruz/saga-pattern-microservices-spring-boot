package com.inventory.application.core.usecase;


import com.inventory.application.core.domain.Sale;
import com.inventory.application.core.domain.enums.SaleEvent;
import com.inventory.application.ports.in.CreditInventoryInputPort;
import com.inventory.application.ports.in.FindInventoryByProductIdInputPort;
import com.inventory.application.ports.out.SendToKafkaOutputPort;
import com.inventory.application.ports.out.UpdateInventoryOutputPort;

public class CreditInventoryUseCase implements CreditInventoryInputPort {

    private final FindInventoryByProductIdInputPort findInventoryByProductIdInputPort;

    private final UpdateInventoryOutputPort updateInventoryOutputPort;

    private final SendToKafkaOutputPort sendToKafkaOutputPort;

    public CreditInventoryUseCase(
            FindInventoryByProductIdInputPort findInventoryByProductIdInputPort,
            UpdateInventoryOutputPort updateInventoryOutputPort,
            SendToKafkaOutputPort sendToKafkaOutputPort
    ) {
        this.findInventoryByProductIdInputPort = findInventoryByProductIdInputPort;
        this.updateInventoryOutputPort = updateInventoryOutputPort;
        this.sendToKafkaOutputPort = sendToKafkaOutputPort;
    }

    @Override
    public void credit(Sale sale) {
        var inventory = findInventoryByProductIdInputPort.find(sale.getProductId());
        inventory.creditQuantity(sale.getQuantity());
        updateInventoryOutputPort.update(inventory);
        sendToKafkaOutputPort.send(sale, SaleEvent.ROLLBACK_INVENTORY);
    }

}
