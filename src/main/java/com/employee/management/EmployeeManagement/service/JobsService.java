package com.employee.management.EmployeeManagement.service;

import com.employee.management.EmployeeManagement.entity.Jobs;
import com.employee.management.EmployeeManagement.repository.JobsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class JobsService {

    @Autowired
    private JobsRepository jobsRepository;

    @Transactional(readOnly = true)
    public Jobs findByID(int id){
        return jobsRepository.findByjobId(id);
    }

    @Transactional(readOnly = true)
    public List<Jobs> allJobs(){
        return jobsRepository.findAll();
    }
}
