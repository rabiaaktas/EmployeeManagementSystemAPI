package com.employee.management.EmployeeManagement.controllers;

import com.employee.management.EmployeeManagement.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryController {
    @Autowired
    private CountryService countryService;

    @RequestMapping(value = "/allCountries", method = RequestMethod.GET)
    public ResponseEntity allCountries(){
        return new ResponseEntity(countryService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/api/addCountry", method = RequestMethod.POST)
    public ResponseEntity addCountry(@RequestParam String name){
        try{
            ResponseEntity serviceResponse = countryService.addCountry(name);
            if(serviceResponse.getStatusCode() == HttpStatus.OK){
                return serviceResponse;
            }
            else{
                return serviceResponse;
            }

        }
        catch (Exception e){
            return new ResponseEntity("Bad Request", HttpStatus.BAD_REQUEST);
        }
    }
}
