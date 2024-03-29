package com.sale.adapters.in.controller;


import com.sale.adapters.in.controller.mapper.SaleRequestMapper;
import com.sale.adapters.in.controller.request.SaleRequest;
import com.sale.application.ports.in.CreateSaleInputPort;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("sales")
public class SaleController {

    private final CreateSaleInputPort createSaleInputPort;

    private final SaleRequestMapper saleRequestMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createSale(@Valid @RequestBody SaleRequest saleRequest) {
        log.info("Criando a venda...");
        createSaleInputPort.create(saleRequestMapper.toSale(saleRequest));
        log.info("Venda criada com sucesso.");
    }
}
