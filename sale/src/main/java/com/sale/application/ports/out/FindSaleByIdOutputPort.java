package com.sale.application.ports.out;


import com.sale.application.core.domain.Sale;

import java.util.Optional;

public interface FindSaleByIdOutputPort {

    Optional<Sale> find(final String id);

}
