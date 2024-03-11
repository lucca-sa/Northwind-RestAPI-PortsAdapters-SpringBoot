package com.hexagonal.restapi.port.customers.input;

import com.hexagonal.restapi.domain.model.Customer;

public interface CriarUseCase {
    Customer criar(Customer customer);
}
