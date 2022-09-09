package com.vlad28x.app.repository.impl;

import com.vlad28x.app.entity.Customer;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepositoryImpl extends AbstractRepository<Long, Customer> {

    public CustomerRepositoryImpl() {
        super(Customer.class);
    }

}
