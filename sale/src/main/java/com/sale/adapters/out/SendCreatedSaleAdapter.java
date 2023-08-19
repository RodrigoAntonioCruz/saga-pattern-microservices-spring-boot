package com.sale.adapters.out;


import com.sale.adapters.out.message.SaleMessage;
import com.sale.application.core.domain.Sale;
import com.sale.application.core.domain.enums.SaleEvent;
import com.sale.application.ports.out.SendCreatedSaleOutputPort;
import com.sale.config.kafka.KafkaPropertiesConfig;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SendCreatedSaleAdapter implements SendCreatedSaleOutputPort {

    private final KafkaTemplate<String, SaleMessage> kafkaTemplate;

    private final KafkaPropertiesConfig kafkaPropertiesConfig;

    @Override
    public void send(Sale sale, SaleEvent event) {
        var saleMessage = new SaleMessage(sale, event);
        kafkaTemplate.send(kafkaPropertiesConfig.getTopicSale(), saleMessage);
    }
}
