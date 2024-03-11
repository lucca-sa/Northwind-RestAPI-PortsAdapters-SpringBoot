package com.hexagonal.restapi.adapter.input.customers.mapper;

import org.mapstruct.Mapper;

import com.hexagonal.restapi.adapter.input.customers.dto.CriarClienteRequest;
import com.hexagonal.restapi.adapter.output.database.entity.CustomerEntity;
import com.hexagonal.restapi.domain.model.Customer;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    Customer toCustomerModel(CustomerEntity customerEntity);
    CustomerEntity toCustomerEntity(Customer customer);
    Customer toCustomerModel(CriarClienteRequest criarClienteRequest);
}
