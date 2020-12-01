package com.employee.management.EmployeeManagement.entity;

import javax.persistence.*;

@Entity
@Table(name = "countries", schema = "employee_management")
public class Countries {
    private int countryID;
    private String countryName;

    @Id
    @Column(name = "countryID", nullable = false)
    public int getCountryID() {
        return countryID;
    }

    public void setCountryID(int countryID) {
        this.countryID = countryID;
    }

    @Basic
    @Column(name = "countryName")
    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

}
