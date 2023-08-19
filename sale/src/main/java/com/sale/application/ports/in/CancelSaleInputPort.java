package com.sale.application.ports.in;


import com.sale.application.core.domain.Sale;

public interface CancelSaleInputPort {

    void cancel(Sale sale);

}
