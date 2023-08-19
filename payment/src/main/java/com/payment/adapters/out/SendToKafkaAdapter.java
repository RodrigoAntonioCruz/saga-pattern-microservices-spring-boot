package com.payment.adapters.out;


import com.payment.adapters.out.message.SaleMessage;
import com.payment.application.core.domain.Sale;
import com.payment.application.core.domain.enums.SaleEvent;
import com.payment.application.ports.out.SendToKafkaOutputPort;
import com.payment.config.kafka.KafkaPropertiesConfig;
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
