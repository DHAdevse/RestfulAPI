package org.example.restfulapi.controllers;

import org.example.restfulapi.models.Department;
import org.example.restfulapi.responses.APIMessages;
import org.example.restfulapi.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    @GetMapping("/all")
    public ResponseEntity<List<Department>> getAllDepartment()
    {
        List <Department> departmentList = departmentService.getAllDepartment();
        return new ResponseEntity<List<Department>>(departmentList, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getDepartment(@PathVariable("id") long id)
    {
        Department department = departmentService.getDepartment(id);
        if(department==null)
        {
            APIMessages apiErr = new APIMessages("CAN NOT FIND THE DEPARTMENT ID: "+id);
            return new ResponseEntity<APIMessages>(apiErr,HttpStatus.NOT_FOUND);
        }
        else
            return new ResponseEntity<Department>(department,HttpStatus.OK);
    }
}
