package com.hexagonal.restapi.adapter.output.database.data.compositekey;

import com.hexagonal.restapi.adapter.output.database.data.entity.CustomerEntity;

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
