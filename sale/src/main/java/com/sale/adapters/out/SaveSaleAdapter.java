package com.sale.adapters.out;


import com.sale.adapters.out.repository.SaleRepository;
import com.sale.adapters.out.repository.mapper.SaleEntityMapper;
import com.sale.application.core.domain.Sale;
import com.sale.application.ports.out.SaveSaleOutputPort;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SaveSaleAdapter implements SaveSaleOutputPort {

    private final SaleRepository saleRepository;

    private final SaleEntityMapper saleEntityMapper;

    @Override
    public Sale save(Sale sale) {
        var saleEntity = saleEntityMapper.toSaleEntity(sale);
        var saleEntityResponse = saleRepository.save(saleEntity);
        return saleEntityMapper.toSale(saleEntityResponse);
    }
}

