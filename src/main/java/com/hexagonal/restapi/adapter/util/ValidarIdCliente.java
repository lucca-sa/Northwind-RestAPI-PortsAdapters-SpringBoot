package com.hexagonal.restapi.adapter.util;

import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;
import org.springframework.validation.Validator;

import com.hexagonal.restapi.adapter.input.customers.dto.ClienteIdRequest;

@Component
public class ValidarIdCliente {

    private Validator validator;

    public ValidarIdCliente(Validator validator) {
        this.validator = validator;
    }

    public void validar(String codigoRoteiro) throws BindException {
        ClienteIdRequest id = new ClienteIdRequest(codigoRoteiro);

        DataBinder binder = new DataBinder(id);
        binder.setValidator(validator);
        binder.validate();

        BindingResult result = binder.getBindingResult();

        if(result.hasErrors()) {
            throw new BindException(result);
        }
    }
}
