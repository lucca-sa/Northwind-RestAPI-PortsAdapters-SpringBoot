package com.hexagonal.restapi.adapter.input.customers.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.hexagonal.restapi.adapter.input.customers.BuscaPorIdSwagger;
import com.hexagonal.restapi.adapter.input.customers.mapper.CustomerMapper;
import com.hexagonal.restapi.adapter.output.database.entity.CustomerEntity;
import com.hexagonal.restapi.domain.model.Customer;
import com.hexagonal.restapi.port.customers.input.BuscaPorIdUseCase;

@RestController
public class BuscaPorIdController implements BuscaPorIdSwagger {
    private final BuscaPorIdUseCase buscaPorIdUseCase;
    private final CustomerMapper customerMapper;

    public BuscaPorIdController(BuscaPorIdUseCase buscaPorIdUseCase, CustomerMapper customerMapper) {
        this.buscaPorIdUseCase = buscaPorIdUseCase;
        this.customerMapper = customerMapper;
    }

    @Override
    public ResponseEntity<CustomerEntity> getCustomerInfo(@PathVariable String customerId) {
        Customer customerInfo = buscaPorIdUseCase.buscar(customerId);

        return ResponseEntity.status(HttpStatus.FOUND).body(customerMapper.toCustomerEntity(customerInfo));
    }
}
