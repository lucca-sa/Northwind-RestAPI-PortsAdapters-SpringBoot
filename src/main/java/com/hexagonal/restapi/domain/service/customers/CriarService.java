package com.hexagonal.restapi.domain.service.customers;

import org.springframework.stereotype.Service;

import com.hexagonal.restapi.domain.model.Customer;
import com.hexagonal.restapi.port.customers.input.CriarUseCase;
import com.hexagonal.restapi.port.customers.output.CriarPort;

@Service
public class CriarService implements CriarUseCase {
    private final CriarPort criarPort;

    public CriarService(CriarPort criarPort) {
        this.criarPort = criarPort;
    }

    @Override
    public Customer criar(Customer customer) {
        return criarPort.criar(customer);
    }
}
