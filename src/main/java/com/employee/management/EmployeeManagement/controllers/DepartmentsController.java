package com.employee.management.EmployeeManagement.controllers;

import com.employee.management.EmployeeManagement.entity.Departments;
import com.employee.management.EmployeeManagement.service.DepartmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DepartmentsController {

    @Autowired
    private DepartmentsService departmentsService;

    @RequestMapping(value = "/api/allDepartments", method = RequestMethod.GET)
    public ResponseEntity allDepartments(){
        try{
            List<Departments> departments = departmentsService.allDepartments();
            return new ResponseEntity(departments, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity("Bad Request", HttpStatus.BAD_REQUEST);
        }
    }
}
