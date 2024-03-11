package com.hexagonal.restapi.port.customers.input;

import com.hexagonal.restapi.domain.model.Customer;

public interface EditarUseCase {
    public Customer editar(String customerId, Customer customer);
}
