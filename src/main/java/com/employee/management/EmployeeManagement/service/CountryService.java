package com.employee.management.EmployeeManagement.service;

import com.employee.management.EmployeeManagement.entity.Countries;
import com.employee.management.EmployeeManagement.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CountryService {
    @Autowired
    private CountryRepository countryRepository;

    @Transactional(readOnly = true)
    public List<Countries> findAll(){
        return countryRepository.findAll();
    }

    @Transactional
    public ResponseEntity addCountry(String name){
        boolean exist = countryRepository.existsByCountryName(name);
        if(!exist){
            Countries countries = new Countries();
            countries.setCountryName(name);
            countryRepository.save(countries);
        }
        else {
            return new ResponseEntity("Not created its already exist.", HttpStatus.CONFLICT);
        }

        return new ResponseEntity(name, HttpStatus.OK);
    }
}
