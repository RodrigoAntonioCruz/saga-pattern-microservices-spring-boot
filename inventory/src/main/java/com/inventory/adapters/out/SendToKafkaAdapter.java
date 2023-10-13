package com.inventory.adapters.out;

import com.inventory.adapters.out.message.SaleMessage;
import com.inventory.application.core.domain.Sale;
import com.inventory.application.core.domain.enums.SaleEvent;
import com.inventory.application.ports.out.SendToKafkaOutputPort;
import com.inventory.configuration.kafka.KafkaPropertiesConfig;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SendToKafkaAdapter implements SendToKafkaOutputPort {

    private final KafkaTemplate<String, SaleMessage> kafkaTemplate;

    private final KafkaPropertiesConfig kafkaPropertiesConfig;

    @Override
    public void send(Sale sale, SaleEvent event) {
        var saleMessage = new SaleMessage(sale, event);
        kafkaTemplate.send(kafkaPropertiesConfig.getTopicSale(), saleMessage);
    }

}
