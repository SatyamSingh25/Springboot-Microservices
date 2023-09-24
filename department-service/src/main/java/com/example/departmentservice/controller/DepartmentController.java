package com.example.departmentservice.controller;

import com.example.departmentservice.client.EmployeeClient;
import com.example.departmentservice.model.Department;
import com.example.departmentservice.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private EmployeeClient employeeClient;

    @PostMapping()
    public Department add(@RequestBody Department department){
        return departmentService.addDepartment(department);
    }

    @GetMapping()
    public List<Department> findAll(){
        return departmentService.findAll();
    }

    @GetMapping("/{id}")
    public Department findByID(@PathVariable("id") Long id){
        return departmentService.departmentById(id);
    }

    @GetMapping("/with-employees")
    public List<Department> findAllWithEmployees(){
        LOGGER.info("Department-wise all employees");
        List<Department> departments = departmentService.findAll();

        //for each department we are setting the employees the
        // by calling employeeClient which is WebClient object by passing deparmemntID
        departments.forEach(department ->
                department.setEmployees(employeeClient.findByDepartmentID(department.getId()))
                );

        return departments;

    }


}
