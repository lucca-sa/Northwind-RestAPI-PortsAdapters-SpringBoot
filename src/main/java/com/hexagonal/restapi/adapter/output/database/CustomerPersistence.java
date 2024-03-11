package com.hexagonal.restapi.adapter.output.database;

import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.hexagonal.restapi.adapter.input.customers.mapper.CustomerMapper;
import com.hexagonal.restapi.adapter.output.database.repository.CustomerRepository;
import com.hexagonal.restapi.domain.model.Customer;
import com.hexagonal.restapi.port.customers.output.BuscaPorIdPort;
import com.hexagonal.restapi.port.customers.output.CriarPort;

import jakarta.transaction.Transactional;

@Component
public class CustomerPersistence implements BuscaPorIdPort, CriarPort {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerPersistence(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public Optional<Customer> buscar(String customerId) {
        Objects.requireNonNull(customerId, "Id não pode ser nulo");
        return customerRepository.findById(customerId).map(customerMapper::toCustomerModel);
    }

    @Override
    @Transactional
    public Customer criar(Customer customer) {
        System.out.println("Chegou no persistance");
        return customerMapper.toCustomerModel(customerRepository.save(customerMapper.toCustomerEntity(customer)));
    }

}
