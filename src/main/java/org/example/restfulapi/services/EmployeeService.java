package org.example.restfulapi.services;

import org.example.restfulapi.models.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    //    Get all Employees
    public List<Employee> getAllEmployee();
    //    Get all Employees of Department
    public List<Employee>getEmployeeOfDepartment(long department_id);
    //    Get employee by id
    public Employee getEmployee(long id);
    //    Create employee
    public Employee addEmployee(Employee employee);
    //    Update employee
    public Employee updateEmployee(Employee employee);
    //    Delete employee
    public boolean deleteEmployee(long id);

}
