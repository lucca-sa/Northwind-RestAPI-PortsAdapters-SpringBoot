package com.hexagonal.restapi.adapter.output.database.compositekey;

import com.hexagonal.restapi.adapter.output.database.entity.CustomerEntity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class CustomerDemoId {
    private CustomerEntity customerId;
    private String customerTypeId;
}
