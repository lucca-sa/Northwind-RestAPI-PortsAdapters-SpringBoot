package com.hexagonal.restapi.adapter.output.database.entity;

import com.hexagonal.restapi.adapter.output.database.compositekey.CustomerDemoId;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer_customer_demo")
@IdClass(CustomerDemoId.class)
public class CustomerDemoEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    @Id
    private  CustomerEntity customerId;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_type_id", nullable = false)
    private CustomerDemoTypeEntity customerTypeId;
}
