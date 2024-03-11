package com.hexagonal.restapi.adapter.input.customers.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexagonal.restapi.adapter.input.customers.BuscaPorIdSwagger;
import com.hexagonal.restapi.adapter.input.customers.mapper.CustomerMapper;
import com.hexagonal.restapi.adapter.output.database.entity.CustomerEntity;
import com.hexagonal.restapi.port.customers.input.BuscaPorIdUseCase;

@RestController
@RequestMapping(value = "/api/customer/{customerId}", produces = { "application/json" })
public class BuscaPorIdController implements BuscaPorIdSwagger {
    private final BuscaPorIdUseCase buscaPorIdUseCase;
    private final CustomerMapper customerMapper;

    public BuscaPorIdController(BuscaPorIdUseCase buscaPorIdUseCase, CustomerMapper customerMapper) {
        this.buscaPorIdUseCase = buscaPorIdUseCase;
        this.customerMapper = customerMapper;
    }

    @Override
    @GetMapping()
    public ResponseEntity<CustomerEntity> getCustomerInfo(@PathVariable String customerId) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(customerMapper.toCustomerEntity(buscaPorIdUseCase.buscar(customerId)));
    }
}
