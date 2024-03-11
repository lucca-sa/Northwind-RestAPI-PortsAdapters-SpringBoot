package com.hexagonal.restapi.adapter.input.customers.dto;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EditarClienteRequest {

    @NotNull(message = "O campo companyName não pode ser vazio.")
    private String companyName;
    private String phone;
    private String contactTitle;
    private String address;
    private String city;
    private String region;
    private String postalCode;
    private String country;
    private String fax;
}
