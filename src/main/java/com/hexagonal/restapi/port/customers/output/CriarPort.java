package com.hexagonal.restapi.port.customers.output;

import com.hexagonal.restapi.domain.model.Customer;

public interface CriarPort {
    Customer criar(Customer customer);
}
