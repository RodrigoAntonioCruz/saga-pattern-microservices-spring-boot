package com.sale.adapters.in.controller.mapper;


import com.sale.adapters.in.controller.request.SaleRequest;
import com.sale.application.core.domain.Sale;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SaleRequestMapper {

    Sale toSale(SaleRequest saleRequest);

}
