package com.sale.adapters.out;


import com.sale.adapters.out.repository.SaleRepository;
import com.sale.adapters.out.repository.mapper.SaleEntityMapper;
import com.sale.application.core.domain.Sale;
import com.sale.application.ports.out.FindSaleByIdOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindSaleByIdAdapter implements FindSaleByIdOutputPort {

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private SaleEntityMapper saleEntityMapper;

    @Override
    public Optional<Sale> find(String id) {
        var saleEntity = saleRepository.findById(id);
        return saleEntity.map(saleEntityMapper::toSale);
    }

}
