package com.hexagonal.restapi.adapter.input.customers.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CriarClienteRequest {
    @NotNull(message = "O campo Id é obrigatório.")
    @Size(min = 5, max = 5, message = "O ID do Cliente deve ser uma string de 5 caracteres.")
    private String id;

    @NotNull(message = "O campo companyName é obrigatório.")
    @Size(min = 1, max = 40, message = "O companyName deve ser uma string de até 40 caracteres.")
    private String companyName;

    @Size(min = 1, max = 40, message = "O contactName deve ser uma string de até 30 caracteres.")
    private String contactName;

    @Size(min = 1, max = 40, message = "O phone deve ser uma string de até 24 caracteres.")
    private String phone;

    @Size(min = 1, max = 40, message = "O contactTitle deve ser uma string de até 30 caracteres.")
    private String contactTitle;

    @Size(min = 1, max = 40, message = "O address deve ser uma string de até 60 caracteres.")
    private String address;

    @Size(min = 1, max = 40, message = "O city deve ser uma string de até 15 caracteres.")
    private String city;

    @Size(min = 1, max = 40, message = "O region deve ser uma string de até 15 caracteres.")
    private String region;

    @Size(min = 1, max = 40, message = "O postalCode deve ser uma string de até 10 caracteres.")
    private String postalCode;

    @Size(min = 1, max = 40, message = "O country deve ser uma string de até 15 caracteres.")
    private String country;

    @Size(min = 1, max = 40, message = "O fax deve ser uma string de até 24 caracteres.")
    private String fax;
}
