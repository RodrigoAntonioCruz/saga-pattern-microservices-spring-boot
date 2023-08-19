package com.sale.application.ports.in;


import com.sale.application.core.domain.Sale;

public interface CreateSaleInputPort {

    void create(Sale sale);

}
