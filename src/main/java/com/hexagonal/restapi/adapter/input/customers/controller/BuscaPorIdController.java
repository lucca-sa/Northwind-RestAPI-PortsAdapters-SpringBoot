package com.hexagonal.restapi.adapter.input.customers.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexagonal.restapi.adapter.input.customers.BuscaPorIdSwagger;
import com.hexagonal.restapi.adapter.input.customers.dto.ClienteResponse;
import com.hexagonal.restapi.adapter.mapper.CustomerMapper;
import com.hexagonal.restapi.port.customers.input.BuscaPorIdUseCase;

@RestController
@RequestMapping(value = "/api/customer/{customerId}", produces = { "application/json" })
public class BuscaPorIdController implements BuscaPorIdSwagger {
    private final BuscaPorIdUseCase buscaPorIdUseCase;
    private final CustomerMapper mapper;

    public BuscaPorIdController(BuscaPorIdUseCase buscaPorIdUseCase, CustomerMapper mapper) {
        this.buscaPorIdUseCase = buscaPorIdUseCase;
        this.mapper = mapper;
    }

    @Override
    @GetMapping()
    public ResponseEntity<ClienteResponse> getCustomerInfo(@PathVariable String customerId) {
        return (ResponseEntity.status(HttpStatus.OK)
                .body(mapper.toCustomerResponse(buscaPorIdUseCase.buscar(customerId))));
    }
}
