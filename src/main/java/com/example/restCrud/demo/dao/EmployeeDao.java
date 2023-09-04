package com.example.restCrud.demo.dao;

import com.example.restCrud.demo.entity.Employee;

import java.util.List;

public interface EmployeeDao {
    List<Employee> findAll();
    Employee findById(int id);

    Employee save(Employee employee);

    void delete(int id);
}
