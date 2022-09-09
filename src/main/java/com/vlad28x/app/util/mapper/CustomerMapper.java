package com.vlad28x.app.util.mapper;

import com.vlad28x.app.dto.CustomerRequestDto;
import com.vlad28x.app.dto.CustomerResponseDto;
import com.vlad28x.app.entity.Customer;

public final class CustomerMapper {

    private CustomerMapper() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static Customer customerRequestDtoToCustomer(CustomerRequestDto dto) {
        Customer customer = new Customer();
        customer.setId(dto.getId());
        customer.setAccount(dto.getAccount());
        return customer;
    }

    public static CustomerResponseDto customerToCustomerResponseDto(Customer customer) {
        CustomerResponseDto dto = new CustomerResponseDto();
        dto.setId(customer.getId());
        dto.setAccount(customer.getAccount());
        return dto;
    }

}
