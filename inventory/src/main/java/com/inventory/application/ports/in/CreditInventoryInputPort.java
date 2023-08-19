package com.inventory.application.ports.in;


import com.inventory.application.core.domain.Sale;

public interface CreditInventoryInputPort {

    void credit(Sale sale);

}
