package org.example.restfulapi.controllers;

import org.apache.catalina.startup.AddPortOffsetRule;
import org.example.restfulapi.models.Employee;
import org.example.restfulapi.responses.APIMessages;
import org.example.restfulapi.responses.EmployeeNotFoundException;
import org.example.restfulapi.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @GetMapping("all")
    public ResponseEntity<List<Employee>>getAllEmployee()
    {
        List<Employee> employeeList = employeeService.getAllEmployee();
        return new ResponseEntity<List<Employee>>(employeeList, HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable("id") long id)
    {
        if(employeeService.getEmployee(id)==null){
            APIMessages apiErr = new APIMessages("NOT FOUND EMPLOYEE ID:" + id);
            return new ResponseEntity<APIMessages>(apiErr, HttpStatus.NOT_FOUND);
        }
        else {
            Employee employee = employeeService.getEmployee(id);
            return new ResponseEntity<Employee>(employee, HttpStatus.OK);
        }
    }
    @GetMapping("department/{id}")
    public ResponseEntity<?> getEmployeeOfDepartment(@PathVariable("id") long id)
    {
        List<Employee> employeeList = employeeService.getEmployeeOfDepartment(id);
        if(employeeList.size()>0)
            return new ResponseEntity<List<Employee>>(employeeList,HttpStatus.OK);
        else {
            APIMessages apiError = new APIMessages(("NOT FOUND EMPLOYEE OF DEPARTMENT: "+ id));
            return new ResponseEntity<APIMessages>(apiError,HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("add")
    public ResponseEntity<?> addEmployee(@RequestBody Employee employee)
    {
        Employee employeeData = employeeService.addEmployee(employee);
        if(employeeData!=null)
            return new ResponseEntity<Employee>(employeeData,HttpStatus.OK);
        else{
            APIMessages apiErr = new APIMessages("CANNOT ADD EMPLOYEE!!");
            return new ResponseEntity<APIMessages>(apiErr,HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("update/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable("id") long id,@RequestBody Employee employee)
    {
        try {
            Employee employee_temp = employeeService.getEmployee(id);
            if (employee_temp == null) {
                APIMessages apiErr = new APIMessages("CAN NOT FOUND TO UPDATE THE EMPLOYEE: " + id);
                return new ResponseEntity<APIMessages>(apiErr, HttpStatus.NOT_FOUND);
            } else {
                employee_temp.setDepartment(employee.getDepartment());
                employee_temp.setEmail(employee.getEmail());
                employee_temp.setGender(employee.getGender());
                employee_temp.setFirstname(employee.getFirstname());
                employee_temp.setLastname(employee_temp.getLastname());
                employee_temp.setDob(employee.getDob());
                return new ResponseEntity<Employee>(employee_temp, HttpStatus.OK);
            }
        }catch(EmployeeNotFoundException ex){
            APIMessages apiErr = new APIMessages(ex.getMessage());
            return new ResponseEntity<APIMessages>(apiErr,HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") long id)
    {
        try {
            Employee employee = employeeService.getEmployee(id);
            if (employee == null) {
                APIMessages apiErr = new APIMessages("NOT FOUND EMPLOYEE TO DELETE: " + id);
                return new ResponseEntity<APIMessages>(apiErr, HttpStatus.NOT_FOUND);
            } else {
                employeeService.deleteEmployee(id);
                APIMessages apiErr = new APIMessages("DELETED THE EMPLOYEE: " + id);
                return new ResponseEntity<APIMessages>(apiErr, HttpStatus.OK);
            }
        }catch (EmployeeNotFoundException ex) {
        APIMessages apiErr = new APIMessages(ex.getMessage());
        return new ResponseEntity<APIMessages>(apiErr, HttpStatus.NOT_FOUND);
    }
    }

}
