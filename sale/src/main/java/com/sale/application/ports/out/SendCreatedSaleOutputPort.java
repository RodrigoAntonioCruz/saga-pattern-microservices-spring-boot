package com.sale.application.ports.out;


import com.sale.application.core.domain.Sale;
import com.sale.application.core.domain.enums.SaleEvent;

public interface SendCreatedSaleOutputPort {

    void send(Sale sale, SaleEvent event);

}
