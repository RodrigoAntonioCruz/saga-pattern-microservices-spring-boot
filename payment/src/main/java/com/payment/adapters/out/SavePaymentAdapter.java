package com.payment.adapters.out;


import com.payment.adapters.out.repository.PaymentRepository;
import com.payment.adapters.out.repository.mapper.PaymentEntityMapper;
import com.payment.application.core.domain.Payment;
import com.payment.application.ports.out.SavePaymentOutputPort;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SavePaymentAdapter implements SavePaymentOutputPort {

    private final PaymentRepository paymentRepository;

    private final PaymentEntityMapper paymentEntityMapper;

    @Override
    public void save(Payment payment) {
        var paymentEntity = paymentEntityMapper.toPaymentEntity(payment);
        paymentRepository.save(paymentEntity);
    }

}
