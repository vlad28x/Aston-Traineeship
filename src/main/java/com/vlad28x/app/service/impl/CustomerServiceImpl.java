package com.vlad28x.app.service.impl;

import com.vlad28x.app.dto.CustomerRequestDto;
import com.vlad28x.app.dto.CustomerResponseDto;
import com.vlad28x.app.dto.ProjectResponseDto;
import com.vlad28x.app.entity.Customer;
import com.vlad28x.app.entity.Project;
import com.vlad28x.app.exception.BadRequestException;
import com.vlad28x.app.exception.NotFoundException;
import com.vlad28x.app.repository.impl.CustomerRepositoryImpl;
import com.vlad28x.app.repository.impl.ProjectRepositoryImpl;
import com.vlad28x.app.service.CustomerService;
import com.vlad28x.app.util.mapper.CustomerMapper;
import com.vlad28x.app.util.mapper.ProjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepositoryImpl customerRepository;
    private final ProjectRepositoryImpl projectRepository;

    public CustomerServiceImpl(CustomerRepositoryImpl customerRepository, ProjectRepositoryImpl projectRepository) {
        this.customerRepository = customerRepository;
        this.projectRepository = projectRepository;
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

    @Override
    public ProjectResponseDto payProject(Long customerId, Long projectId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new NotFoundException(String.format("Customer with ID %s not found", customerId)));
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new NotFoundException(String.format("Project with ID %s not found", projectId)));
        if (project.getCustomer().getId() != customerId)
            throw new BadRequestException(String.format("The customer with ID %s doesn't have the project with ID %s", customerId, projectId));
        Long payment = project.getPayment();
        Long account = customer.getAccount();
        if (payment <= account) {
            customer.setAccount(account - payment);
            project.setPayment(0L);
        } else {
            customer.setAccount(0L);
            project.setPayment(payment - account);
        }
        return ProjectMapper.projectToProjectResponseDto(project);
    }
}
