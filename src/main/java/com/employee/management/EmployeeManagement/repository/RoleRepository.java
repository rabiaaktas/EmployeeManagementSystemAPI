package com.employee.management.EmployeeManagement.repository;

import com.employee.management.EmployeeManagement.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByroleId(int id);
}
