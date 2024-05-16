package com.hexagonal.restapi.domain.service.customers;

import org.springframework.stereotype.Service;

import com.hexagonal.restapi.domain.model.Customer;
import com.hexagonal.restapi.port.customers.input.EditarUseCase;
import com.hexagonal.restapi.port.customers.output.EditarPort;

@Service
public class EditarService implements EditarUseCase {

    private final EditarPort editarPort;

    public EditarService(EditarPort editarPort) {
        this.editarPort = editarPort;
    }

    @Override
    public Customer editar(String customerId, Customer customer) {
        return editarPort.editar(customer, customerId);
    }
}
