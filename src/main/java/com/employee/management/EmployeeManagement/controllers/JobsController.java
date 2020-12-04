package com.employee.management.EmployeeManagement.controllers;

import com.employee.management.EmployeeManagement.entity.Jobs;
import com.employee.management.EmployeeManagement.service.JobsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobsController {

    @Autowired
    private JobsService jobsService;

    @RequestMapping(value = "/api/getJobById/{id}", method = RequestMethod.GET)
    public Jobs findByID(@PathVariable int id){
        return jobsService.findByID(id);
    }
}
