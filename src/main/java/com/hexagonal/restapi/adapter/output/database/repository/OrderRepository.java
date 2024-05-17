package com.hexagonal.restapi.adapter.output.database.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexagonal.restapi.adapter.output.database.data.entity.CustomerEntity;
import com.hexagonal.restapi.adapter.output.database.data.entity.OrderEntity;


public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {
    List<OrderEntity> findByCustomerId(CustomerEntity customerId);
}
