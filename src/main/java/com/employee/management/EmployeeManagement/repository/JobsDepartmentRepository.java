package com.employee.management.EmployeeManagement.repository;

import com.employee.management.EmployeeManagement.entity.JobsDepartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobsDepartmentRepository extends JpaRepository<JobsDepartment, Integer> {
}
