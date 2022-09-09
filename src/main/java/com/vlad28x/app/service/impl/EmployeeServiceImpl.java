package com.vlad28x.app.service.impl;

import com.vlad28x.app.dto.EmployeeRequestDto;
import com.vlad28x.app.dto.EmployeeResponseDto;
import com.vlad28x.app.entity.Employee;
import com.vlad28x.app.exception.NotFoundException;
import com.vlad28x.app.repository.impl.EmployeeRepositoryImpl;
import com.vlad28x.app.service.EmployeeService;
import com.vlad28x.app.util.mapper.EmployeeMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepositoryImpl employeeRepository;

    public EmployeeServiceImpl(EmployeeRepositoryImpl employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeResponseDto getById(Long id) {
        return EmployeeMapper.employeeToEmployeeResponseDto(employeeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Employee with ID %s not found", id))));
    }

    @Override
    public List<EmployeeResponseDto> getAll() {
        return employeeRepository.findAll().stream()
                .map(EmployeeMapper::employeeToEmployeeResponseDto).collect(Collectors.toList());
    }

    @Override
    public EmployeeResponseDto create(EmployeeRequestDto newEmployee) {
        return EmployeeMapper.employeeToEmployeeResponseDto(
                employeeRepository.save(EmployeeMapper.employeeRequestDtoToEmployee(newEmployee))
        );
    }

    @Override
    public EmployeeResponseDto update(Long id, EmployeeRequestDto newEmployee) {
        Employee employee = EmployeeMapper.employeeRequestDtoToEmployee(newEmployee);
        employee.setId(id);
        return EmployeeMapper.employeeToEmployeeResponseDto(employeeRepository.update(employee));
    }

    @Override
    public void delete(Long id) {
        employeeRepository.delete(id);
    }
}
