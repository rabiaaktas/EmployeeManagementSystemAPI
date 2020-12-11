package com.employee.management.EmployeeManagement.controllers;

import com.employee.management.EmployeeManagement.entity.JobHistory;
import com.employee.management.EmployeeManagement.entity.Userroles;
import com.employee.management.EmployeeManagement.model.UserJobInformationDTO;
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
    public Userroles getEmpRoleById(@PathVariable int id){
        return userService.getUserRoleByEmpId(id);
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
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/api/jobHistory/{id}", method = RequestMethod.GET)
    public List<JobHistory> getHistory(@PathVariable int id){
            List<JobHistory> histories = userService.getHistoryOfUser(id);
            return histories;
    }

    @RequestMapping(value = "/api/employeeInformation/{id}", method = RequestMethod.GET)
    public List<UserJobInformationDTO> employeeInfGet(@PathVariable int id){
        List<UserJobInformationDTO> list = userService.getJobInfoEmployee(id);
        return list;
    }


}
