package com.sale.application.ports.in;


import com.sale.application.core.domain.Sale;

public interface FindSaleByIdInputPort {

    Sale find(final String id);

}
