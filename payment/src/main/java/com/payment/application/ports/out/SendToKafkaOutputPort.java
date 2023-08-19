package com.payment.application.ports.out;


import com.payment.application.core.domain.Sale;
import com.payment.application.core.domain.enums.SaleEvent;

public interface SendToKafkaOutputPort {

    void send(Sale sale, SaleEvent event);

}
