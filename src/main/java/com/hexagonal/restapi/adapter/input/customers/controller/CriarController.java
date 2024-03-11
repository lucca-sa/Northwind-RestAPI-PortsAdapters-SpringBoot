package com.hexagonal.restapi.adapter.input.customers.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexagonal.restapi.adapter.input.customers.CriarSwagger;
import com.hexagonal.restapi.adapter.input.customers.dto.CriarClienteRequest;
import com.hexagonal.restapi.adapter.input.customers.mapper.CustomerMapper;
import com.hexagonal.restapi.adapter.output.database.entity.CustomerEntity;
import com.hexagonal.restapi.domain.model.Customer;
import com.hexagonal.restapi.port.customers.input.CriarUseCase;


@RestController
@RequestMapping(value = "/api/customer", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class CriarController implements CriarSwagger {
    private final CriarUseCase criarUseCase;
    private final CustomerMapper mapper;

    public CriarController(CriarUseCase criarUseCase, CustomerMapper mapper) {
        this.criarUseCase = criarUseCase;
        this.mapper = mapper;
    }

    @PostMapping    
    @Override
    public ResponseEntity<CustomerEntity> postCustomer(@RequestBody CriarClienteRequest criarClienteRequest) {
        System.out.println(criarClienteRequest.getId());
        Customer criar = criarUseCase.criar(mapper.toCustomerModel(criarClienteRequest));
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toCustomerEntity(criar));
    }
}
