package com.example.restCrud.demo.rest;

import com.example.restCrud.demo.dao.EmployeeDao;
import com.example.restCrud.demo.entity.Employee;
import com.example.restCrud.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployeesById(@PathVariable("employeeId") int employeeId){
        Employee employee = employeeService.findById(employeeId);
        if (employee==null){
            throw new RuntimeException("Employee not Found");
        }
        return employee;
    }

    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee employee){
        //when id is 0 will save new employee data
        employee.setId(0);
        Employee dbEmployee = employeeService.save(employee);
        return dbEmployee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        Employee dbEmployee = employeeService.save(employee);
        return dbEmployee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public void deleteEmployee(@PathVariable("employeeId") int employeeId){
        if (employeeService.findById(employeeId)==null){
            throw new RuntimeException("Employee Not Found");
        }
        employeeService.delete(employeeId);
    }
}
