package com.hexagonal.restapi.port.customers.output;

import com.hexagonal.restapi.domain.model.Customer;

public interface BuscaPorIdPort {
    Customer buscar(String customerId);
}
