package com.employee.management.EmployeeManagement.repository;

import com.employee.management.EmployeeManagement.entity.Jobs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobsRepository extends JpaRepository<Jobs, Integer> {
    Jobs findByjobId(int id);
    Jobs findByjobIdAndJobName(int id, String name);
    Jobs findByJobName(String name);
    List<Jobs> findAll();
    boolean existsByJobName(String jobName);
}
