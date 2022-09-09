package com.vlad28x.app.controller;


import com.vlad28x.app.dto.CustomerRequestDto;
import com.vlad28x.app.dto.CustomerResponseDto;
import com.vlad28x.app.dto.ProjectResponseDto;
import com.vlad28x.app.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {


    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponseDto> getCustomerById(@PathVariable Long id) {
        return ResponseEntity.ok(customerService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponseDto>> getAllCustomers() {
        return ResponseEntity.ok(customerService.getAll());
    }

    @PostMapping
    public ResponseEntity<CustomerResponseDto> createCustomer(@RequestBody CustomerRequestDto newCustomer) {
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.create(newCustomer));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerResponseDto> updateCustomer(@PathVariable Long id, @RequestBody CustomerRequestDto newCustomer) {
        return ResponseEntity.ok(customerService.update(id, newCustomer));
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerService.delete(id);
    }

    @PatchMapping("/pay/{customerId}/{projectId}")
    public ResponseEntity<ProjectResponseDto> payProject(@PathVariable Long customerId, @PathVariable Long projectId) {
        return ResponseEntity.ok(customerService.payProject(customerId, projectId));
    }

}
