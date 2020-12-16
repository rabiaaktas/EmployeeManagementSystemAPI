package com.employee.management.EmployeeManagement.repository;

import com.employee.management.EmployeeManagement.entity.Managers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository extends JpaRepository<Managers, Integer> {
    boolean existsByemployeeId(int employeeId);
}
