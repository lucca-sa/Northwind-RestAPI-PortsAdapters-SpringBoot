package com.hexagonal.restapi.domain.service.customers;

import org.springframework.stereotype.Service;

import com.hexagonal.restapi.port.customers.input.DeletarPorIdUseCase;
import com.hexagonal.restapi.port.customers.output.DeletarPort;

@Service
public class DeletarPorIdService implements DeletarPorIdUseCase {
    private final DeletarPort port;

    public DeletarPorIdService(DeletarPort port) {
        this.port = port;
    }

    @Override
    public String deletar(String customerId) {
        return port.deletar(customerId);
    }
}
