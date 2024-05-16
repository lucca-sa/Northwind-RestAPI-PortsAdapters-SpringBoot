package com.hexagonal.restapi.adapter.output.database.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexagonal.restapi.adapter.output.database.compositekey.CustomerDemoId;
import com.hexagonal.restapi.adapter.output.database.entity.CustomerDemoEntity;
import com.hexagonal.restapi.adapter.output.database.entity.CustomerEntity;

public interface CustomerDemoRepository extends JpaRepository<CustomerDemoEntity, CustomerDemoId> {
    List<CustomerDemoEntity> findByCustomerId(CustomerEntity customerId);
}
