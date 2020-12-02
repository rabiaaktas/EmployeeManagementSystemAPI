package com.employee.management.EmployeeManagement.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "countries", schema = "employee_management")
public class Countries {
    private int countryID;
    private String countryName;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Countries countries = (Countries) o;
        return countryID == countries.countryID &&
                Objects.equals(countryName, countries.countryName);
    }

    @Override
    public int hashCode(){
        return Objects.hash(countryID, countryName);
    }

}
