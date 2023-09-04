package com.example.restCrud.demo.dao;

import com.example.restCrud.demo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{
    private EntityManager entityManager;

    @Autowired
    public EmployeeDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> employeeTypedQuery = entityManager.createQuery("FROM Employee",Employee.class);
        List<Employee> employeeList = employeeTypedQuery.getResultList();
        return employeeList;
    }

    @Override
    public Employee findById(int id) {
        return entityManager.find(Employee.class,id);
    }

    @Override
    public Employee save(Employee employee) {
        Employee employee1 = entityManager.merge(employee);
        return employee1;
    }

    @Override
    public void delete(int id) {
        Employee employee = entityManager.find(Employee.class,id);
        entityManager.remove(employee);
    }


}
