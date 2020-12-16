package com.employee.management.EmployeeManagement.service;

import com.employee.management.EmployeeManagement.entity.Jobs;
import com.employee.management.EmployeeManagement.entity.JobsDepartment;
import com.employee.management.EmployeeManagement.model.AddJobDTO;
import com.employee.management.EmployeeManagement.model.UserJobInformationDTO;
import com.employee.management.EmployeeManagement.repository.JobsDepartmentRepository;
import com.employee.management.EmployeeManagement.repository.JobsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Service
public class JobsService {

    @Autowired
    private JobsRepository jobsRepository;

    @Autowired
    private JobsDepartmentRepository jobsDepartmentRepository;

    @Autowired
    private EntityManager entityManager;

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

    @Transactional
    public List<UserJobInformationDTO> getJobInfoEmployee(int id){
        Query query = entityManager.createNativeQuery("SELECT e.employeeID, e.first_name, e.last_name, e.email_employee, e.phone_number, e.jobId, j.job_title, d.department_name, d.managerId\n" +
                "FROM employees e, jobs j, departments d WHERE e.jobId = j.jobID AND e.departmentId = d.departmentID AND e.employeeID = ?1").setParameter(1, id);
        return query.getResultList();
    }
}
