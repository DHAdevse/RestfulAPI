package org.example.restfulapi.services;

import org.example.restfulapi.models.Department;

import java.util.List;

public interface DepartmentService {
    //    Get list Department
    public List<Department> getAllDepartment();
    public Department getDepartment(long id);
}
