package com.vlad28x.app.util.mapper;

import com.vlad28x.app.dto.EmployeeRequestDto;
import com.vlad28x.app.dto.EmployeeResponseDto;
import com.vlad28x.app.entity.Employee;

public final class EmployeeMapper {

    private EmployeeMapper() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static Employee employeeRequestDtoToEmployee(EmployeeRequestDto dto) {
        Employee employee = new Employee();
        employee.setId(dto.getId());
        employee.setHireDate(dto.getHireDate());
        employee.setPosition(dto.getPosition());
        return employee;
    }

    public static EmployeeResponseDto employeeToEmployeeResponseDto(Employee employee) {
        EmployeeResponseDto dto = new EmployeeResponseDto();
        dto.setId(employee.getId());
        dto.setHireDate(employee.getHireDate());
        dto.setPosition(employee.getPosition());
        return dto;
    }

}
