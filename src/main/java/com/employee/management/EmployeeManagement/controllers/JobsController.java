package com.employee.management.EmployeeManagement.controllers;

import com.employee.management.EmployeeManagement.entity.Jobs;
import com.employee.management.EmployeeManagement.model.AddJobDTO;
import com.employee.management.EmployeeManagement.model.UserJobInformationDTO;
import com.employee.management.EmployeeManagement.service.JobsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobsController {

    @Autowired
    private JobsService jobsService;

    @RequestMapping(value = "/api/getJobById/{id}", method = RequestMethod.GET)
    @CrossOrigin
    public Jobs findByID(@PathVariable int id){
        return jobsService.findByID(id);
    }

    @RequestMapping(value = "/api/allJobs", method = RequestMethod.GET)
    @CrossOrigin
    public List<Jobs> allJobs(){
        return jobsService.allJobs();
    }

    @RequestMapping(value = "/api/addJob", method = RequestMethod.POST)
    @CrossOrigin
    public ResponseEntity addJob(@RequestBody AddJobDTO addJobDTO){
        return jobsService.addJob(addJobDTO);
    }

    @RequestMapping(value = "/api/employeeJobInformation/{id}", method = RequestMethod.GET)
    @CrossOrigin
    public List<UserJobInformationDTO> employeeInfGet(@PathVariable int id){
        return jobsService.getJobInfoEmployee(id);
    }
}
