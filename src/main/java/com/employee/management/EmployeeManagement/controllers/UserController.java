package com.employee.management.EmployeeManagement.controllers;

import com.employee.management.EmployeeManagement.entity.Userroles;
import com.employee.management.EmployeeManagement.repository.UserrolesRepository;
import com.employee.management.EmployeeManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/api/getRoleById/{id}", method = RequestMethod.GET)
    public ResponseEntity getEmpRoleById(@PathVariable int id){
        return new ResponseEntity(userService.getUserRoleByEmpId(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/api/addRoleToUser", method = RequestMethod.POST)
    public ResponseEntity addRole(@RequestParam int employeeId, @RequestParam int roleId){
        try{
            ResponseEntity a = userService.addRoleToUser(employeeId, roleId);
            if(a.getStatusCode() == HttpStatus.OK){
                return new ResponseEntity("Created successfully", HttpStatus.OK);
            }
            else{
                return new ResponseEntity("Conflict", HttpStatus.CONFLICT);
            }
        }
        catch (Exception e){
            return new ResponseEntity("Bad Request", HttpStatus.BAD_REQUEST);
        }
    }


}
