package com.sale.application.core.usecase;


import com.sale.application.core.domain.Sale;
import com.sale.application.ports.in.FindSaleByIdInputPort;
import com.sale.application.ports.out.FindSaleByIdOutputPort;

public class FindSaleByIdUseCase implements FindSaleByIdInputPort {

    private final FindSaleByIdOutputPort findSaleByIdOutputPort;

    public FindSaleByIdUseCase(
            FindSaleByIdOutputPort findSaleByIdOutputPort
    ) {
        this.findSaleByIdOutputPort = findSaleByIdOutputPort;
    }

    @Override
    public Sale find(final String id) {
        return findSaleByIdOutputPort.find(id)
                .orElseThrow(() -> new RuntimeException("Venda não encontrada!"));
    }

}
