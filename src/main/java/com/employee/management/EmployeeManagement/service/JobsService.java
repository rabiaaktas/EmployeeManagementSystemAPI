package com.employee.management.EmployeeManagement.service;

import com.employee.management.EmployeeManagement.entity.Jobs;
import com.employee.management.EmployeeManagement.repository.JobsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobsService {

    @Autowired
    private JobsRepository jobsRepository;

    public Jobs findByID(int id){
        return jobsRepository.findByjobId(id);
    }
}
