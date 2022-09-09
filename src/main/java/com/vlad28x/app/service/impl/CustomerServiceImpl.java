package com.vlad28x.app.service.impl;

import com.vlad28x.app.dto.CustomerRequestDto;
import com.vlad28x.app.dto.CustomerResponseDto;
import com.vlad28x.app.entity.Customer;
import com.vlad28x.app.exception.NotFoundException;
import com.vlad28x.app.repository.impl.CustomerRepositoryImpl;
import com.vlad28x.app.service.CustomerService;
import com.vlad28x.app.util.mapper.CustomerMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepositoryImpl customerRepository;

    public CustomerServiceImpl(CustomerRepositoryImpl customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerResponseDto getById(Long id) {
        return CustomerMapper.customerToCustomerResponseDto(customerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Customer with ID %s not found", id))));
    }

    @Override
    public List<CustomerResponseDto> getAll() {
        return customerRepository.findAll().stream()
                .map(CustomerMapper::customerToCustomerResponseDto).collect(Collectors.toList());
    }

    @Override
    public CustomerResponseDto create(CustomerRequestDto newCustomer) {
        return CustomerMapper.customerToCustomerResponseDto(
                customerRepository.save(CustomerMapper.customerRequestDtoToCustomer(newCustomer))
        );
    }

    @Override
    public CustomerResponseDto update(Long id, CustomerRequestDto newCustomer) {
        Customer customer = CustomerMapper.customerRequestDtoToCustomer(newCustomer);
        customer.setId(id);
        return CustomerMapper.customerToCustomerResponseDto(customerRepository.update(customer));
    }

    @Override
    public void delete(Long id) {
        customerRepository.delete(id);
    }
}
