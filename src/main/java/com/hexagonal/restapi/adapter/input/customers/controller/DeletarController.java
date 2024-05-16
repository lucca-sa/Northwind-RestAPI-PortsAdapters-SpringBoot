package com.hexagonal.restapi.adapter.input.customers.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexagonal.restapi.adapter.input.customers.DeletarSwagger;
import com.hexagonal.restapi.adapter.util.ValidarIdCliente;
import com.hexagonal.restapi.adapter.util.dto.MessageResponse;
import com.hexagonal.restapi.port.customers.input.DeletarPorIdUseCase;

@RestController
@RequestMapping(value = "/api/customer/{customerId}", produces = { "application/json" })
public class DeletarController implements DeletarSwagger {
    private final DeletarPorIdUseCase useCase;
    private final ValidarIdCliente validarId;

    public DeletarController(DeletarPorIdUseCase useCase,
            ValidarIdCliente validarId) {
        this.useCase = useCase;
        this.validarId = validarId;
    }

    @Override
    @DeleteMapping()
    public ResponseEntity<MessageResponse> deleteCustomer(@PathVariable String customerId) throws BindException {
        validarId.validar(customerId);
        return ResponseEntity.ok(new MessageResponse(useCase.deletar(customerId)));
    }
}
