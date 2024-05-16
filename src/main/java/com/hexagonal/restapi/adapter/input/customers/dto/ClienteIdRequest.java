package com.hexagonal.restapi.adapter.input.customers.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ClienteIdRequest {
    
    @NotNull(message = "O campo Id é obrigatório.")
    @Size(min = 5, max = 5, message = "O ID do Cliente deve ser uma string de 5 caracteres.")
    private String customerId;

    public ClienteIdRequest() {
    }

    public ClienteIdRequest(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}
