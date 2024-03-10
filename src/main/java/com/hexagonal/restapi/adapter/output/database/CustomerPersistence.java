package com.hexagonal.restapi.adapter.output.database;

import java.util.NoSuchElementException;
import org.springframework.stereotype.Component;

import com.hexagonal.restapi.adapter.input.customers.mapper.CustomerMapper;
import com.hexagonal.restapi.adapter.output.database.entity.CustomerEntity;
import com.hexagonal.restapi.adapter.output.database.repository.CustomerRepository;
import com.hexagonal.restapi.domain.model.Customer;
import com.hexagonal.restapi.port.customers.output.BuscaPorIdPort;

@Component
public class CustomerPersistence implements BuscaPorIdPort {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerPersistence(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public Customer buscar(String customerId) {
        CustomerEntity customerInfo = customerRepository.findById(customerId)
                .orElseThrow(
                        () -> new NoSuchElementException("Cliente com Id " + customerId + " não foi encontrado."));

        return customerMapper.toCustomerModel(customerInfo);
    }

}
