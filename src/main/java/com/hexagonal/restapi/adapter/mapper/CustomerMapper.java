package com.hexagonal.restapi.adapter.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.hexagonal.restapi.adapter.input.customers.dto.ClienteResponse;
import com.hexagonal.restapi.adapter.input.customers.dto.CriarClienteRequest;
import com.hexagonal.restapi.adapter.input.customers.dto.EditarClienteRequest;
import com.hexagonal.restapi.adapter.output.database.entity.CustomerEntity;
import com.hexagonal.restapi.domain.model.Customer;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CustomerMapper {
    Customer toCustomerModel(CustomerEntity customerEntity);
    CustomerEntity toCustomerEntity(Customer customer);
    Customer toCustomerModel(CriarClienteRequest criarClienteRequest);
    Customer toCustomerModel(EditarClienteRequest editarClienteRequest);
    void updateCustomerFromDto(Customer source, @MappingTarget Customer target);
    ClienteResponse toCustomerResponse(Customer customer);
}
