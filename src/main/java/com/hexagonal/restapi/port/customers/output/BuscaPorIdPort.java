package com.hexagonal.restapi.port.customers.output;

import java.util.Optional;

import com.hexagonal.restapi.domain.model.Customer;

public interface BuscaPorIdPort {
    Optional<Customer> buscar(String customerId);
}
