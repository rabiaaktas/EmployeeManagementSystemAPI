package com.employee.management.EmployeeManagement.model;

public class DepartmentLocationGetDTO {

    private String city;
    private String streetAddress;
    private  String countryName;

    public DepartmentLocationGetDTO(String city, String streetAddress, String countryName){
        this.city = city;
        this.streetAddress = streetAddress;
        this.countryName = countryName;
    }


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

}
