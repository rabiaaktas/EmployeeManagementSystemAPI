package com.employee.management.EmployeeManagement.controllers;

import com.employee.management.EmployeeManagement.entity.Jobs;
import com.employee.management.EmployeeManagement.model.AddJobDTO;
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
    public Jobs findByID(@PathVariable int id){
        return jobsService.findByID(id);
    }

    @RequestMapping(value = "/api/allJobs", method = RequestMethod.GET)
    public List<Jobs> allJobs(){
            List<Jobs> jobs = jobsService.allJobs();
            return jobs;
    }

    @RequestMapping(value = "/api/addJob", method = RequestMethod.POST)
    public ResponseEntity addJob(@RequestBody AddJobDTO addJobDTO){
        ResponseEntity serviceResponse = jobsService.addJob(addJobDTO);
        if (serviceResponse.getStatusCode() == HttpStatus.OK){
            return new ResponseEntity("created", HttpStatus.OK);
        }
        else if (serviceResponse.getStatusCode() == HttpStatus.CONFLICT){
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
}
