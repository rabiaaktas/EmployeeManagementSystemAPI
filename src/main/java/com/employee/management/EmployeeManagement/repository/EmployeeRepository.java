package com.employee.management.EmployeeManagement.repository;

import com.employee.management.EmployeeManagement.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employees, Integer> {

    Employees findByemployeeID(int id);
    Employees findByemail(String email);
    Employees findByfirstNameAndLastName(String first_name, String last_name);
    List<Employees> findAllBydepartmentId(int id);
    List<Employees> findAllBymanagerId(int id);
    boolean existsByemail(String email);
}
