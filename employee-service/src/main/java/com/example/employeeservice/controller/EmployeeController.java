package com.example.employeeservice.controller;

import com.example.employeeservice.model.Employee;
import com.example.employeeservice.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    @PostMapping()
    public Employee addEmployee(@RequestBody Employee employee){
        LOGGER.info("Employee add: {}", employee);
        return employeeService.addEmployee(employee);
    }

    @GetMapping()
    public List<Employee> allEmployee(){
        LOGGER.info("All Employee");
        return employeeService.allEmployee();
    }

    @GetMapping("/{id}")
    Employee EmployeeByID(@PathVariable("id") Long id){
        LOGGER.info("Employee by ID: {}", id);
        return employeeService.employeeByID(id);
    }

    @GetMapping("/department/{departmentID}")
    public List<Employee>  findByDepartmentID(@PathVariable("departmentID") Long id){
        LOGGER.info("Employee if Department ID: {}", id);
        return employeeService.findByDepartmentID(id);
    }

}
