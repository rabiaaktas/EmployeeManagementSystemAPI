package com.employee.management.EmployeeManagement.controllers;

import com.employee.management.EmployeeManagement.entity.Departments;
import com.employee.management.EmployeeManagement.model.DepartmentLocationGetDTO;
import com.employee.management.EmployeeManagement.service.CountryService;
import com.employee.management.EmployeeManagement.service.DepartmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DepartmentsController {

    @Autowired
    private DepartmentsService departmentsService;

    @Autowired
    private CountryService countryService;

    @RequestMapping(value = "/api/allDepartments", method = RequestMethod.GET)
    public List<Departments> allDepartments(){
            List<Departments> departments = departmentsService.allDepartments();
            return departments;
    }

    @RequestMapping(value = "/api/getDepartments", method = RequestMethod.GET)
    public List<Departments> getDepartments(@RequestBody DepartmentLocationGetDTO departmentLocationGetDTO){
        List<Departments> departments = countryService.getDepartmentsByLocation(departmentLocationGetDTO.getCity(), departmentLocationGetDTO.getStreetAddress(), departmentLocationGetDTO.getCountryName());
        return departments;
    }
}
