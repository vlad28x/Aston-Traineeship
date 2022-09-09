package com.vlad28x.app.repository.impl;

import com.vlad28x.app.entity.Employee;
import com.vlad28x.app.entity.enums.Position;
import org.springframework.stereotype.Repository;


import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class EmployeeRepositoryImpl extends AbstractRepository<Long, Employee> {

    public EmployeeRepositoryImpl() {
        super(Employee.class);
    }

    public List<Employee> findDevelopers() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> criteria = cb.createQuery(clazz);
        Root<Employee> root = criteria.from(clazz);
        criteria.where(cb.equal(root.get("position"), Position.DEVELOPER));
        return entityManager.createQuery(criteria)
                .getResultList();
    }

}
