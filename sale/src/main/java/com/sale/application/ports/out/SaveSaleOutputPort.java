package com.sale.application.ports.out;


import com.sale.application.core.domain.Sale;

public interface SaveSaleOutputPort {

    Sale save(Sale sale);

}
