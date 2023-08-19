package com.payment.application.ports.in;


import com.payment.application.core.domain.Sale;

public interface SalePaymentInputPort {

    void payment(Sale sale);

}
