package com.hexagonal.restapi.domain.service.customers;

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
        return buscaPorIdPort.buscar(customerId);
    }
}
