package com.payment.configuration.usecase;


import com.payment.adapters.out.SavePaymentAdapter;
import com.payment.adapters.out.SendToKafkaAdapter;
import com.payment.adapters.out.UpdateUserAdapter;
import com.payment.application.core.usecase.FindUserByIdUseCase;
import com.payment.application.core.usecase.SalePaymentUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SalePaymentConfig {

    @Bean
    public SalePaymentUseCase salePaymentUseCase(
            FindUserByIdUseCase findUserByIdUseCase,
            UpdateUserAdapter updateUserAdapter,
            SavePaymentAdapter savePaymentAdapter,
            SendToKafkaAdapter sendToKafkaAdapter
    ) {
        return new SalePaymentUseCase(findUserByIdUseCase, updateUserAdapter, savePaymentAdapter, sendToKafkaAdapter);
    }

}
