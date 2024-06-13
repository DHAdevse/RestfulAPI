package org.example.restfulapi.services.impl;

import org.example.restfulapi.models.Department;
import org.example.restfulapi.repositories.DepartmentRepository;
import org.example.restfulapi.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public List<Department> getAllDepartment() {
        List<Department> departmentList;
        departmentList = departmentRepository.findAll();
        return departmentList;
    }
    @Override
    public Department getDepartment(long id)
    {
        Department department = departmentRepository.getOne(id);
        return department;
    }
}
