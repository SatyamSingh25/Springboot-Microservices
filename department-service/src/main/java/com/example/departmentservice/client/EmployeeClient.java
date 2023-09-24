package com.example.departmentservice.client;

import com.example.departmentservice.model.Employee;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;

//we cannot directly create a object this beacause its not creating the BEAN
//so, we have to create the config for creating the bean.
@HttpExchange
public interface EmployeeClient {
    @GetExchange("/employee/department/{departmentID}")
    public List<Employee> findByDepartmentID(@PathVariable("departmentID") Long id);


}