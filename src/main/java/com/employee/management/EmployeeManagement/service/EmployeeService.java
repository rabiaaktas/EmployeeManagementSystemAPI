package com.employee.management.EmployeeManagement.service;

import com.employee.management.EmployeeManagement.entity.Employees;
import com.employee.management.EmployeeManagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional(readOnly = true)
    public List<Employees> getEmployeesByDepartmentID(int id){
        return employeeRepository.findAllBydepartmentId(id);
    }

    @Transactional(readOnly = true)
    public Employees findByEmployeeID(int id){
        return employeeRepository.findByemployeeID(id);
    }

    @Transactional(readOnly = true)
    public Employees findByNameAndSurname(String name, String surname){
        return employeeRepository.findByfirstNameAndLastName(name, surname);
    }

    @Transactional(readOnly = true)
    public Employees findEmployeeByEmail(String email){
        return employeeRepository.findByemail(email);
    }

    @Transactional
    public ResponseEntity addEmployee(Employees employees){
        boolean exist = employeeRepository.existsByemail(employees.getEmail());
        if(!exist){
            employeeRepository.save(employees);
        }
        else{
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
        return new ResponseEntity(HttpStatus.OK);
    }
}
