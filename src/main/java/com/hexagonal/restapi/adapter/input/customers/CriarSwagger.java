package com.hexagonal.restapi.adapter.input.customers;

import org.springframework.http.ResponseEntity;

import com.hexagonal.restapi.adapter.input.customers.dto.ClienteResponse;
import com.hexagonal.restapi.adapter.input.customers.dto.CriarClienteRequest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Clientes")
public interface CriarSwagger {
    @Operation(summary = "Criar Cadastro de Cliente")
    public ResponseEntity<ClienteResponse> postCustomer(@Valid @RequestBody CriarClienteRequest criarClienteRequest);
}
