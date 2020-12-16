package com.employee.management.EmployeeManagement.controllers;

import com.employee.management.EmployeeManagement.entity.Departments;
import com.employee.management.EmployeeManagement.model.DepartmentLocationGetDTO;
import com.employee.management.EmployeeManagement.service.CountryService;
import com.employee.management.EmployeeManagement.service.DepartmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentsController {

    @Autowired
    private DepartmentsService departmentsService;

    @RequestMapping(value = "/api/allDepartments", method = RequestMethod.GET)
    @CrossOrigin
    public List<Departments> allDepartments(){
        return departmentsService.allDepartments();
    }

    @RequestMapping(value = "/api/getDepartments", method = RequestMethod.GET)
    @CrossOrigin
    public List<Departments> getDepartments(@RequestBody DepartmentLocationGetDTO departmentLocationGetDTO){
        return departmentsService.getDepartmentsByLocation(departmentLocationGetDTO.getCity(), departmentLocationGetDTO.getStreetAddress(), departmentLocationGetDTO.getCountryName());
    }

    @RequestMapping(value = "/api/addDepartment", method = RequestMethod.POST)
    @CrossOrigin
    public ResponseEntity addDepartmentObj(@RequestBody Departments departments){
        return departmentsService.addDepartment(departments);
    }

    @RequestMapping(value = "/api/deleteDepartment/{id}", method = RequestMethod.POST)
    @CrossOrigin
    public ResponseEntity deleteDepartment(@PathVariable int id){
        return departmentsService.deleteDepartment(id);
    }


}
