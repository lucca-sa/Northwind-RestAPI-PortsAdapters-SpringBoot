package com.hexagonal.restapi.port.customers.output;

import com.hexagonal.restapi.domain.model.Customer;

public interface EditarPort {
    Customer editar(Customer customer, String customerId);
}
