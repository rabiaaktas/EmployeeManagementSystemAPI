package com.employee.management.EmployeeManagement.service;

import com.employee.management.EmployeeManagement.entity.Departments;
import com.employee.management.EmployeeManagement.repository.DepartmentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DepartmentsService {

    @Autowired
    private DepartmentsRepository departmentsRepository;

    @Transactional(readOnly = true)
    public List<Departments> allDepartments(){
        return departmentsRepository.findAll();
    }
}
