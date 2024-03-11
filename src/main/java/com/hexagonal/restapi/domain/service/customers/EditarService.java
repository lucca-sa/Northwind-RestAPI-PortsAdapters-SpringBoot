package com.hexagonal.restapi.domain.service.customers;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hexagonal.restapi.domain.model.Customer;
import com.hexagonal.restapi.port.customers.input.EditarUseCase;
import com.hexagonal.restapi.port.customers.output.BuscaPorIdPort;
import com.hexagonal.restapi.port.customers.output.EditarPort;

@Service
public class EditarService implements EditarUseCase {

    public final BuscaPorIdPort buscaPorIdPort;
    private final EditarPort editarPort;

    public EditarService(BuscaPorIdPort buscaPorIdPort, EditarPort editarPort) {
        this.buscaPorIdPort = buscaPorIdPort;
        this.editarPort = editarPort;
    }

    @Override
    public Customer editar(String customerId, Customer customer) {
        Optional<Customer> customerInfo = buscaPorIdPort.buscar(customerId.toUpperCase());

        if (!customerInfo.isPresent()) {
            throw new NoSuchElementException("Cliente com Id " + customerId + " não foi encontrado.");
        }
        Customer entity = customer;
        entity.setId(customerId.toUpperCase());
        entity.setContactName(customerInfo.get().getContactName());

        return editarPort.editar(entity);
    }
}
