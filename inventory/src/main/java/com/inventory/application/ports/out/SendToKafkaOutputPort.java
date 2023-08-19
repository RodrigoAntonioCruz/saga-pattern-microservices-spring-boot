package com.inventory.application.ports.out;


import com.inventory.application.core.domain.Sale;
import com.inventory.application.core.domain.enums.SaleEvent;

public interface SendToKafkaOutputPort {

    void send(Sale sale, SaleEvent event);

}
