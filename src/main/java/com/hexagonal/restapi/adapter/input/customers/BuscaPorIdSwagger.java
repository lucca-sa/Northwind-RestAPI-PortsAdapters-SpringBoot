package com.hexagonal.restapi.adapter.input.customers;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.PathVariable;

import com.hexagonal.restapi.adapter.input.customers.dto.ClienteResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;


@Tag(name = "Clientes")
public interface BuscaPorIdSwagger {

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cliente encontrado."),
            @ApiResponse(responseCode = "404", description = "Cliente não encontrado.")
    })
    @Operation(summary = "Busca de Cliente por ID")
    public ResponseEntity<ClienteResponse> getCustomerInfo(@PathVariable String customerId) throws BindException;
}
