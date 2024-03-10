package com.hexagonal.restapi.adapter.input.customers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hexagonal.restapi.adapter.output.database.entity.CustomerEntity;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RequestMapping(value = "/api", produces = { "application/json" })
@Tag(name = "Clientes")
public interface BuscaPorIdSwagger {

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cliente encontrado."),
            @ApiResponse(responseCode = "404", description = "Cliente não encontrado.")
    })
    @Operation(summary = "Busca de Cliente por ID")
    @GetMapping("/customer/{customerId}")
    public ResponseEntity<CustomerEntity> getCustomerInfo(@PathVariable String customerId);
}
