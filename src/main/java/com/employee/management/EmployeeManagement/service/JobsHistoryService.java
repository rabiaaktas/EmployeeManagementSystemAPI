package com.employee.management.EmployeeManagement.service;

import com.employee.management.EmployeeManagement.repository.JobsHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class JobsHistoryService {

    @Autowired
    private JobsHistoryRepository jobsHistoryRepository;



}
