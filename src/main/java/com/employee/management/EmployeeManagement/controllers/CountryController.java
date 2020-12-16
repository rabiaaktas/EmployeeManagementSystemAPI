package com.employee.management.EmployeeManagement.controllers;

import com.employee.management.EmployeeManagement.entity.Countries;
import com.employee.management.EmployeeManagement.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CountryController {
    @Autowired
    private CountryService countryService;

    @RequestMapping(value = "/allCountries", method = RequestMethod.GET)
    @CrossOrigin
    public List<Countries> allCountries(){
        return countryService.findAll();
    }

    @RequestMapping(value = "/api/addCountry", method = RequestMethod.POST)
    @CrossOrigin
    public ResponseEntity addCountry(@RequestParam String name){
        try{
            return countryService.addCountry(name);
        }
        catch (Exception e){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/api/deleteCountry/{id}", method = RequestMethod.POST)
    @CrossOrigin
    public ResponseEntity deleteCountry(@PathVariable int id){
        return countryService.deleteCountry(id);

    }

    @RequestMapping(value = "/api/updateCountry", method = RequestMethod.POST)
    @CrossOrigin
    public ResponseEntity updateCountry(@RequestBody Countries countries){
        return countryService.update(countries);
    }
}
