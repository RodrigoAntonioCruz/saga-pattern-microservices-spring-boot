package com.payment.application.ports.out;


import com.payment.application.core.domain.Payment;

public interface SavePaymentOutputPort {

    void save(Payment payment);

}
