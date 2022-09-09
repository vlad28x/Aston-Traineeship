package com.vlad28x.app.controller;


import com.vlad28x.app.dto.EmployeeRequestDto;
import com.vlad28x.app.dto.EmployeeResponseDto;
import com.vlad28x.app.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponseDto> getEmployeeById(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<EmployeeResponseDto>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAll());
    }

    @PostMapping
    public ResponseEntity<EmployeeResponseDto> createEmployee(@RequestBody EmployeeRequestDto newEmployee) {
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.create(newEmployee));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeResponseDto> updateEmployee(@PathVariable Long id, @RequestBody EmployeeRequestDto newEmployee) {
        return ResponseEntity.ok(employeeService.update(id, newEmployee));
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.delete(id);
    }

    @GetMapping("/developers")
    public ResponseEntity<List<EmployeeResponseDto>> getAllDevelopers() {
        return ResponseEntity.ok(employeeService.getAllDevelopers());
    }

}
