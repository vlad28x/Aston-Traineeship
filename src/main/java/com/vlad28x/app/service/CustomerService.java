package com.vlad28x.app.service;

import com.vlad28x.app.dto.CustomerRequestDto;
import com.vlad28x.app.dto.CustomerResponseDto;
import com.vlad28x.app.dto.UserRequestDto;
import com.vlad28x.app.dto.UserResponseDto;

import java.util.List;

public interface CustomerService {

    CustomerResponseDto getById(Long id);

    List<CustomerResponseDto> getAll();

    CustomerResponseDto create(CustomerRequestDto newCustomer);

    CustomerResponseDto update(Long id, CustomerRequestDto newCustomer);

    void delete(Long id);

}
