package com.hexagonal.restapi.adapter.input.customers.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexagonal.restapi.adapter.input.customers.EditarSwagger;
import com.hexagonal.restapi.adapter.input.customers.dto.EditarClienteRequest;
import com.hexagonal.restapi.adapter.input.customers.mapper.CustomerMapper;
import com.hexagonal.restapi.adapter.output.database.entity.CustomerEntity;
import com.hexagonal.restapi.domain.model.Customer;
import com.hexagonal.restapi.port.customers.input.EditarUseCase;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/customer", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class EditarController implements EditarSwagger {
    private final EditarUseCase useCase;
    private final CustomerMapper mapper;

    public EditarController(EditarUseCase useCase, CustomerMapper mapper) {
        this.useCase = useCase;
        this.mapper = mapper;
    }

    @Override
    @PutMapping("/{customerId}")
    public ResponseEntity<CustomerEntity> putCustomer(@PathVariable String customerId, @Valid @RequestBody EditarClienteRequest editarClienteRequest) {
        Customer editar = useCase.editar(customerId, mapper.toCustomerModel(editarClienteRequest));
        return ResponseEntity.status(HttpStatus.OK).body(mapper.toCustomerEntity(editar));
    }
}
