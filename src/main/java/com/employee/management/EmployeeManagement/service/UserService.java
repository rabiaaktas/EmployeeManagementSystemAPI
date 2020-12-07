package com.employee.management.EmployeeManagement.service;

import com.employee.management.EmployeeManagement.entity.Userroles;
import com.employee.management.EmployeeManagement.repository.UserrolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserrolesRepository userrolesRepository;

    @Transactional(readOnly = true)
    public Userroles getUserRoleByEmpId(int id){
        return userrolesRepository.findByEmployeeId(id);
    }

    @Transactional
    public ResponseEntity addRoleToUser(int employeeId, int roleId){
        boolean exist = userrolesRepository.existsByemployeeIdAndRoleId(employeeId, roleId);
        if(!exist){
            Userroles role = new Userroles();
            role.setRoleId(roleId);
            role.setEmployeeId(employeeId);
            userrolesRepository.save(role);
            return new ResponseEntity(roleId, HttpStatus.OK);
        }
        else{
            return new ResponseEntity("Already exists", HttpStatus.CONFLICT);
        }

    }
}
