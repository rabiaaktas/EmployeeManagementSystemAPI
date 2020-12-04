package com.employee.management.EmployeeManagement.service;

import com.employee.management.EmployeeManagement.entity.Countries;
import com.employee.management.EmployeeManagement.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {
    @Autowired
    private CountryRepository countryRepository;
    public List<Countries> findAll(){
        return countryRepository.findAll();
    }
}
