package com.inventory.application.core.usecase;


import com.inventory.application.core.domain.Sale;
import com.inventory.application.core.domain.enums.SaleEvent;
import com.inventory.application.ports.in.DebitInventoryInputPort;
import com.inventory.application.ports.in.FindInventoryByProductIdInputPort;
import com.inventory.application.ports.out.SendToKafkaOutputPort;
import com.inventory.application.ports.out.UpdateInventoryOutputPort;

public class DebitInventoryUseCase implements DebitInventoryInputPort {

    private final FindInventoryByProductIdInputPort findInventoryByProductIdInputPort;

    private final UpdateInventoryOutputPort updateInventoryOutputPort;

    private final SendToKafkaOutputPort sendToKafkaOutputPort;

    public DebitInventoryUseCase(
            FindInventoryByProductIdInputPort findInventoryByProductIdInputPort,
            UpdateInventoryOutputPort updateInventoryOutputPort,
            SendToKafkaOutputPort sendToKafkaOutputPort
    ) {
        this.findInventoryByProductIdInputPort = findInventoryByProductIdInputPort;
        this.updateInventoryOutputPort = updateInventoryOutputPort;
        this.sendToKafkaOutputPort = sendToKafkaOutputPort;
    }

    @Override
    public void debit(Sale sale) {
        try {
            var inventory = findInventoryByProductIdInputPort.find(sale.getProductId());
            if (inventory.getQuantity() < sale.getQuantity()) {
                throw new RuntimeException("Estoque insuficiente");
            }
            inventory.debitQuantity(sale.getQuantity());
            updateInventoryOutputPort.update(inventory);
            sendToKafkaOutputPort.send(sale, SaleEvent.UPDATED_INVENTORY);
        } catch(Exception e) {
            sendToKafkaOutputPort.send(sale, SaleEvent.ROLLBACK_INVENTORY);
        }
    }

}
