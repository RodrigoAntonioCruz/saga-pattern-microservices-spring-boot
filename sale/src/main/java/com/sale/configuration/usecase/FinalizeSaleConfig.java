package com.sale.configuration.usecase;


import com.sale.adapters.out.SaveSaleAdapter;
import com.sale.application.core.usecase.FinalizeSaleUseCase;
import com.sale.application.core.usecase.FindSaleByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FinalizeSaleConfig {

    @Bean
    public FinalizeSaleUseCase finalizeSaleUseCase(
            FindSaleByIdUseCase findSaleByIdUseCase,
            SaveSaleAdapter saveSaleAdapter
    ) {
        return new FinalizeSaleUseCase(findSaleByIdUseCase, saveSaleAdapter);
    }

}
