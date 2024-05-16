package com.hexagonal.restapi.adapter.output.database;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.hexagonal.restapi.adapter.mapper.CustomerMapper;
import com.hexagonal.restapi.adapter.output.database.entity.CustomerEntity;
import com.hexagonal.restapi.adapter.output.database.repository.CustomerRepository;
import com.hexagonal.restapi.domain.exception.DataConflictException;
import com.hexagonal.restapi.domain.model.Customer;
import com.hexagonal.restapi.port.customers.output.BuscaPorIdPort;
import com.hexagonal.restapi.port.customers.output.CriarPort;
import com.hexagonal.restapi.port.customers.output.EditarPort;

import jakarta.transaction.Transactional;

@Component
public class CustomerPersistence implements BuscaPorIdPort, CriarPort, EditarPort {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerPersistence(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public Customer buscar(String customerId) {
        return customerRepository.findById(customerId).map(customerMapper::toCustomerModel)
                .orElseThrow(() -> new NoSuchElementException("Cliente com ID '" + customerId + "' não foi encontrado."));
    }

    @Override
    @Transactional
    public Customer criar(Customer customer) {
        customer.setId(customer.getId().toUpperCase());
        Optional<CustomerEntity> customerExistente = customerRepository.findById(customer.getId());

        if (customerExistente.isPresent()) {
            throw new DataConflictException("Cliente com o ID '" + customer.getId() + "' já existe.");
        }

        return customerMapper.toCustomerModel(customerRepository.save(customerMapper.toCustomerEntity(customer)));
    }

    @Override
    @Transactional
    public Customer editar(Customer customer, String customerId) {
        Customer customerInfo = buscar(customerId.toUpperCase());
        customerMapper.updateCustomerFromDto(customer, customerInfo);
        return customerMapper.toCustomerModel(customerRepository.save(customerMapper.toCustomerEntity(customerInfo)));
    }
}
