package com.hexagonal.restapi.domain.service.customers;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hexagonal.restapi.domain.model.Customer;
import com.hexagonal.restapi.port.customers.input.BuscaPorIdUseCase;
import com.hexagonal.restapi.port.customers.output.BuscaPorIdPort;

@Service
public class BuscaPorIdService implements BuscaPorIdUseCase {

    private final BuscaPorIdPort buscaPorIdPort;

    public BuscaPorIdService(BuscaPorIdPort buscaPorIdPort) {
        this.buscaPorIdPort = buscaPorIdPort;
    }

    @Override
    public Customer buscar(String customerId) {
        Optional<Customer> customerInfo = buscaPorIdPort.buscar(customerId.toUpperCase());

        if(customerInfo.isPresent()) {
            return customerInfo.get();
        }

        throw new NoSuchElementException("Cliente com Id " + customerId + " não foi encontrado.");
    }
}
