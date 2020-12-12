package com.employee.management.EmployeeManagement.service;

import com.employee.management.EmployeeManagement.entity.Jobs;
import com.employee.management.EmployeeManagement.entity.JobsDepartment;
import com.employee.management.EmployeeManagement.model.AddJobDTO;
import com.employee.management.EmployeeManagement.repository.JobsDepartmentRepository;
import com.employee.management.EmployeeManagement.repository.JobsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class JobsService {

    @Autowired
    private JobsRepository jobsRepository;

    @Autowired
    private JobsDepartmentRepository jobsDepartmentRepository;

    @Transactional(readOnly = true)
    public Jobs findByID(int id){
        return jobsRepository.findByjobId(id);
    }

    @Transactional(readOnly = true)
    public List<Jobs> allJobs(){
        return jobsRepository.findAll();
    }

    @Transactional
    public ResponseEntity addJob(AddJobDTO addJobDTO){
        boolean exist = jobsRepository.existsByJobName(addJobDTO.getJobName());
        if(!exist){
            Jobs jobs = new Jobs();
            jobs.setJobName(addJobDTO.getJobName());
            jobs.setMinSalary(addJobDTO.getMinSalary());
            jobs.setMaxSalary(addJobDTO.getMaxSalary());
            jobsRepository.save(jobs);
            JobsDepartment jobsDepartment = new JobsDepartment();
            jobsDepartment.setDepartmentId(addJobDTO.getDepartmentId());
            jobsDepartment.setJobId(jobs.getJobId());
            jobsDepartmentRepository.save(jobsDepartment);

        }
        else {
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
        return new ResponseEntity(HttpStatus.OK);
    }
}
