package com.vlad28x.app.service;

import com.vlad28x.app.dto.CustomerRequestDto;
import com.vlad28x.app.dto.CustomerResponseDto;
import com.vlad28x.app.dto.EmployeeRequestDto;
import com.vlad28x.app.dto.EmployeeResponseDto;

import java.util.List;

public interface EmployeeService {

    EmployeeResponseDto getById(Long id);

    List<EmployeeResponseDto> getAll();

    EmployeeResponseDto create(EmployeeRequestDto newEmployee);

    EmployeeResponseDto update(Long id, EmployeeRequestDto newEmployee);

    void delete(Long id);

}
