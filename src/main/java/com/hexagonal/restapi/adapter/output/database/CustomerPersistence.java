package com.hexagonal.restapi.adapter.output.database;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.hexagonal.restapi.adapter.mapper.CustomerMapper;
import com.hexagonal.restapi.adapter.output.database.entity.CustomerEntity;
import com.hexagonal.restapi.adapter.output.database.entity.OrderEntity;
import com.hexagonal.restapi.adapter.output.database.repository.CustomerRepository;
import com.hexagonal.restapi.adapter.output.database.repository.OrderRepository;
import com.hexagonal.restapi.domain.exception.DataConflictException;
import com.hexagonal.restapi.domain.model.Customer;
import com.hexagonal.restapi.port.customers.output.BuscaPorIdPort;
import com.hexagonal.restapi.port.customers.output.CriarPort;
import com.hexagonal.restapi.port.customers.output.DeletarPort;
import com.hexagonal.restapi.port.customers.output.EditarPort;

import jakarta.transaction.Transactional;

@Component
public class CustomerPersistence implements BuscaPorIdPort, CriarPort, EditarPort, DeletarPort {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    private final OrderRepository orderRepository;


    public CustomerPersistence(CustomerRepository customerRepository, CustomerMapper customerMapper,
            OrderRepository orderRepository) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
        this.orderRepository = orderRepository;
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

    @Override
    @Transactional
    public String deletar(String customerId) {
        customerId = customerId.toUpperCase();
        CustomerEntity customerInfo = customerMapper.toCustomerEntity(buscar(customerId));
        List<OrderEntity> orders = orderRepository.findByCustomerId(customerInfo);

        if(orders.isEmpty()) {
            customerRepository.deleteById(customerId);
            return "Cliente com o ID '" + customerId + "' foi excluído com sucesso.";
        }

        throw new DataConflictException("Clientes com pedidos cadastrados não podem ser excluídos.");
    }
}
