package com.employee.management.EmployeeManagement.repository;

import com.employee.management.EmployeeManagement.entity.Departments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentsRepository extends JpaRepository<Departments, Integer> {
    Departments findBydepartmentId(int id);
    Departments findBydepartmentName(String name);
    List<Departments> findAll();
}
