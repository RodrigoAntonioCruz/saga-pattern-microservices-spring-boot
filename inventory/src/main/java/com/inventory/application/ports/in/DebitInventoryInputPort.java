package com.inventory.application.ports.in;


import com.inventory.application.core.domain.Sale;

public interface DebitInventoryInputPort {

    void debit(Sale sale);

}
