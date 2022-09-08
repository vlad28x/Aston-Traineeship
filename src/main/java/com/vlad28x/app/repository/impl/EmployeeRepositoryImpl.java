package com.vlad28x.app.repository.impl;

import com.vlad28x.app.entity.Employee;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepositoryImpl extends AbstractRepository<Long, Employee> {

    protected EmployeeRepositoryImpl() {
        super(Employee.class);
    }

}
