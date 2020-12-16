package com.employee.management.EmployeeManagement.controllers;

import com.employee.management.EmployeeManagement.entity.Role;
import com.employee.management.EmployeeManagement.entity.Userroles;
import com.employee.management.EmployeeManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/api/getRoleById/{id}", method = RequestMethod.GET)
    @CrossOrigin
    public Userroles getEmpRoleById(@PathVariable int id){
        return userService.getUserRoleByEmpId(id);
    }

    @RequestMapping(value = "/api/getRoleNameById/{id}", method = RequestMethod.GET)
    @CrossOrigin
    public String getEmpRoleNameById(@PathVariable int id){
        Userroles userroles = userService.getUserRoleByEmpId(id);
        return userService.userRoleName(userroles);
    }

    @RequestMapping(value = "/api/addRoleToUser", method = RequestMethod.POST)
    @CrossOrigin
    public ResponseEntity addRole(@RequestBody Userroles userroles){
        return userService.addRoleToUser(userroles.getEmployeeId(), userroles.getRoleId());
    }


}
