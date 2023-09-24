package com.example.departmentservice.service;

import com.example.departmentservice.model.Department;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentService {
    private List<Department> departments = new ArrayList<>();

    public Department addDepartment(Department department){
        departments.add(department);
        return department;
    }

    public Department departmentById(long id){
        return departments.stream()
                .filter(department -> department.getId() == id)
                .findFirst().get();
    }

    public List<Department> findAll(){
        return this.departments;
    }
}
