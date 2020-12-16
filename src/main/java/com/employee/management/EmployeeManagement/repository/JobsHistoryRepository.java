package com.employee.management.EmployeeManagement.repository;

import com.employee.management.EmployeeManagement.entity.JobHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobsHistoryRepository extends JpaRepository<JobHistory, Integer> {
}
