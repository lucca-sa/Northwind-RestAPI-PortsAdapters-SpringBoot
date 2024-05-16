package com.hexagonal.restapi.adapter.input.customers;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.PathVariable;

import com.hexagonal.restapi.adapter.util.dto.MessageResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Clientes")
public interface DeletarSwagger {
    @Operation(summary = "Deletar Cliente por ID")
    public ResponseEntity<MessageResponse> deleteCustomer(@PathVariable String customerId) throws BindException;
}
