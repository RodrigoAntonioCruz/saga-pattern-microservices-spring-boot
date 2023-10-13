package com.sale.adapters.in.consumer;


import com.sale.adapters.out.message.SaleMessage;
import com.sale.application.core.domain.enums.SaleEvent;
import com.sale.application.ports.in.CancelSaleInputPort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class CancelSaleConsumer {

    private final CancelSaleInputPort cancelSaleInputPort;

    @KafkaListener(topics = "${spring.kafka.topic-sale}", groupId = "${spring.kafka.group-id-cancel}")
    public void receive(SaleMessage saleMessage) {
        if(SaleEvent.ROLLBACK_INVENTORY.equals(saleMessage.getEvent())) {
            log.info("Cancelando a venda...");
            cancelSaleInputPort.cancel(saleMessage.getSale());
            log.info("Venda cancelada com sucesso");
        }
    }

}
