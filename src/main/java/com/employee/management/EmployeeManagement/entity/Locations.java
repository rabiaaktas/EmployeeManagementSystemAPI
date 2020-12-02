package com.employee.management.EmployeeManagement.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "locations")
public class Locations {

    private int locationId;
    private String streetAddress;
    private String city;
    private int countryId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "locationID", nullable = false)
    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    @Basic
    @Column(name = "street_address")
    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    @Basic
    @Column(name = "city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "countryId")
    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Locations locations = (Locations) o;
        return locationId == locations.locationId &&
                Objects.equals(streetAddress, locations.streetAddress) &&
                Objects.equals(city, locations.city) &&
                Objects.equals(countryId, locations.countryId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(locationId, streetAddress, city, countryId);
    }
}
