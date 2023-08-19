package com.sale.adapters.in.consumer;


import com.sale.adapters.out.message.SaleMessage;
import com.sale.application.core.domain.enums.SaleEvent;
import com.sale.application.ports.in.FinalizeSaleInputPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ReceiveSaleToFinalizeConsumer {

    @Autowired
    private FinalizeSaleInputPort finalizeSaleInputPort;

    @KafkaListener(topics = "${spring.kafka.topic-sale}", groupId = "${spring.kafka.group-id-finalize}")
    public void receive(SaleMessage saleMessage) {
        if(SaleEvent.VALIDATED_PAYMENT.equals(saleMessage.getEvent())) {
            log.info("Finalizando a venda...");
            finalizeSaleInputPort.finalize(saleMessage.getSale());
            log.info("Venda finalizada com sucesso.");
        }
    }

}
