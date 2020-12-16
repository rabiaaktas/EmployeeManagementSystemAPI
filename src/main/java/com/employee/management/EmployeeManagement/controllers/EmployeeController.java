package com.employee.management.EmployeeManagement.controllers;

import com.employee.management.EmployeeManagement.entity.Employees;
import com.employee.management.EmployeeManagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/api/getEmployeesByDepartment/{id}", method = RequestMethod.GET)
    @CrossOrigin
    public List<Employees> getEmployeesByDepartment(@PathVariable int id){
        return employeeService.getEmployeesByDepartmentID(id);
    }

    @RequestMapping(value = "/api/employeeInf/{id}", method = RequestMethod.GET)
    @CrossOrigin
    public Employees getEmployeeByID(@PathVariable int id){
        return employeeService.findByEmployeeID(id);
    }

    @RequestMapping(value = "/api/employee/{name}/{surname}", method = RequestMethod.GET)
    @CrossOrigin
    public Employees findByNameandSurname(@PathVariable String name, @PathVariable String surname){
        return employeeService.findByNameAndSurname(name, surname);
    }

    @RequestMapping(value = "/api/getEmployeeByEmail/{email}", method = RequestMethod.GET)
    @CrossOrigin
    public Employees findByEmail(@PathVariable String email){
        return employeeService.findEmployeeByEmail(email);
    }

    @RequestMapping(value = "/api/addEmployee", method = RequestMethod.POST)
    @CrossOrigin
    public ResponseEntity addEmployee(@RequestBody Employees employees){
        return employeeService.addEmployee(employees);
    }
}
