package com.employee.management.EmployeeManagement.service;

import com.employee.management.EmployeeManagement.entity.Countries;
import com.employee.management.EmployeeManagement.entity.Departments;
import com.employee.management.EmployeeManagement.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Service
public class CountryService {
    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private EntityManager entityManager;

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
            return new ResponseEntity(HttpStatus.CONFLICT);
        }

        return new ResponseEntity(HttpStatus.OK);
    }

    @Transactional
    public List<Departments> getDepartmentsByLocation(String city, String streetAddress, String countryName){
        Query location = entityManager.createNativeQuery("SELECT d.* " +
                "FROM departments d, locations l, countries c " +
                "WHERE d.locationId = l.locationID AND l.countryId = c.countryID AND " +
                "(l.city LIKE ?1 OR l.street_address LIKE ?2 OR c.countryName LIKE ?3)")
                .setParameter(1, "%" + city + "%")
                .setParameter(2, "%" + streetAddress + "%")
                .setParameter(3, "%"+ countryName + "%");
        return location.getResultList();
    }

}
