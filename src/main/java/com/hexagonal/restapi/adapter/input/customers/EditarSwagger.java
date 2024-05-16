package com.hexagonal.restapi.adapter.input.customers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import com.hexagonal.restapi.adapter.input.customers.dto.ClienteResponse;
import com.hexagonal.restapi.adapter.input.customers.dto.EditarClienteRequest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Clientes")
public interface EditarSwagger {
    @Operation(summary = "Editar Cadastro de Cliente")
    public ResponseEntity<ClienteResponse> putCustomer(@PathVariable String customerId, @Valid @RequestBody EditarClienteRequest editarClienteRequest);
}
