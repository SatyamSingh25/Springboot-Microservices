package com.example.employeeservice.service;

import com.example.employeeservice.model.Employee;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {


    private List<Employee> employeeList = new ArrayList<>();

    public Employee addEmployee(Employee employee){
        employeeList.add(employee);
        return employee;
    }

    public Employee employeeByID(Long id){
        return employeeList.stream()
                .filter(emp -> emp.getId() == id)
                .findFirst().get();
    }

    public List<Employee> allEmployee(){
        return employeeList;
    }

    public List<Employee> findByDepartmentID(Long id){
        return employeeList.stream()
                .filter(department -> department.getDepartmentId() == id)
                .toList();
    }
}
