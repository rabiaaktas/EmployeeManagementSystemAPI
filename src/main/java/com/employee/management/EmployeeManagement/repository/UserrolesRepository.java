package com.employee.management.EmployeeManagement.repository;

import com.employee.management.EmployeeManagement.entity.Userroles;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserrolesRepository extends JpaRepository<Userroles, Integer> {
    Userroles findByEmployeeId(int id);
    Userroles findByemployeeIdAndRoleId(int employeeId, int roleId);
    boolean existsByemployeeIdAndRoleId(int employeeId, int roleId);
}
