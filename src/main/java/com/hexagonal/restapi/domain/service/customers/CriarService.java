package com.hexagonal.restapi.domain.service.customers;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hexagonal.restapi.domain.model.Customer;
import com.hexagonal.restapi.port.customers.input.CriarUseCase;
import com.hexagonal.restapi.port.customers.output.BuscaPorIdPort;
import com.hexagonal.restapi.port.customers.output.CriarPort;

@Service
public class CriarService implements CriarUseCase {
    private final BuscaPorIdPort buscaPorIdPort;
    private final CriarPort criarPort;

    public CriarService(BuscaPorIdPort buscaPorIdPort, CriarPort criarPort) {
        this.buscaPorIdPort = buscaPorIdPort;
        this.criarPort = criarPort;
    }

    @Override
    public Customer criar(Customer customer) {
        Optional<Customer> customerExists = buscaPorIdPort.buscar(customer.getId());

        if (customerExists.isPresent()) {
            throw new NoSuchElementException("Já existe");
        }

        return criarPort.criar(customer);
    }
}
