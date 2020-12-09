package com.employee.management.EmployeeManagement.controllers;

import com.employee.management.EmployeeManagement.entity.JobHistory;
import com.employee.management.EmployeeManagement.entity.Userroles;
import com.employee.management.EmployeeManagement.model.UserrolesDTO;
import com.employee.management.EmployeeManagement.repository.UserrolesRepository;
import com.employee.management.EmployeeManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/api/getRoleById/{id}", method = RequestMethod.GET)
    public ResponseEntity getEmpRoleById(@PathVariable int id){
        return new ResponseEntity(userService.getUserRoleByEmpId(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/api/addRoleToUser", method = RequestMethod.POST)
    public ResponseEntity addRole(@RequestBody UserrolesDTO userrolesDTO){
        try{
            ResponseEntity serviceResponse = userService.addRoleToUser(userrolesDTO.getEmployeeId(), userrolesDTO.getRoleId());
            if(serviceResponse.getStatusCode() == HttpStatus.OK){
                return serviceResponse;
            }
            else{
                return serviceResponse;
            }
        }
        catch (Exception e){
            return new ResponseEntity("Bad Request", HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/api/jobHistory/{id}", method = RequestMethod.GET)
    public ResponseEntity getHistory(@PathVariable int id){
        try {
            List<JobHistory> histories = userService.getHistoryOfUser(id);
            return new ResponseEntity(histories, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity("Bad Request", HttpStatus.BAD_REQUEST);
        }
    }


}
