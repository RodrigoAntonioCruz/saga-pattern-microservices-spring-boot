package com.payment.adapters.out.repository.mapper;


import com.payment.adapters.out.repository.mapper.entity.PaymentEntity;
import com.payment.application.core.domain.Payment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentEntityMapper {

    PaymentEntity toPaymentEntity(Payment payment);

}
