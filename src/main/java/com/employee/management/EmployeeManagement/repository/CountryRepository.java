package com.employee.management.EmployeeManagement.repository;

import com.employee.management.EmployeeManagement.entity.Countries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Countries, Integer> {
    Countries findBycountryID(int id);
    @Override
    List<Countries> findAll();
}
