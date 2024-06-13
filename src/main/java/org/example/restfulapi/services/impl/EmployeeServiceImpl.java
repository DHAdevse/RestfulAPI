package org.example.restfulapi.services.impl;

import org.example.restfulapi.models.Employee;
import org.example.restfulapi.repositories.EmployeeRepository;
import org.example.restfulapi.responses.EmployeeNotFoundException;
import org.example.restfulapi.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public List<Employee> getAllEmployee()
    {
        return employeeRepository.findAll();
    }
    @Override
    public List<Employee> getEmployeeOfDepartment(long department_id) {
        return employeeRepository.getEmployeeDepartment(department_id);
    }
    @Override
    public Employee getEmployee(long id) {
        return employeeRepository.getEmployeeById(id);
//                .orElseThrow(() -> new EmployeeNotFoundException("Employee Not Found Id: "+id));
    }
    @Override
    public Employee addEmployee(Employee employee) {
        return  employeeRepository.save(employee);
    }
    @Override
    public Employee updateEmployee(Employee employee) {
        employee = employeeRepository.save(employee);
        return employee;
    }
    @Override
    public boolean deleteEmployee(long id) {
        Employee employee = employeeRepository.getOne(id);
        if(employee!= null)
        {
            employeeRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
