package com.employee.management.EmployeeManagement.repository;

import com.employee.management.EmployeeManagement.entity.Userroles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserrolesRepository extends JpaRepository<Userroles, Integer> {
    Userroles findByEmployeeId(int id);
    Userroles findByemployeeIdAndroleId(int employeeId, int roleId);
}
