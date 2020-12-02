package com.employee.management.EmployeeManagement.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "departments", schema = "employee_management")
public class Departments {

    private int departmentId;
    private String departmentName;
    private int managerId;
    private int locationId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "departmentID", nullable = false)
    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    @Basic
    @Column(name = "department_name", length = 200)
    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Basic
    @Column(name = "managerId")
    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    @Basic
    @Column(name = "locationId")
    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Departments departments = (Departments) o;
        return departmentId == departments.departmentId &&
                Objects.equals(departmentName, departments.departmentName) &&
                Objects.equals(managerId, departments.managerId) &&
                Objects.equals(locationId, departments.locationId);
    }

    @Override
    public int hashCode(){
        return Objects.hash(departmentId, departmentName, managerId, locationId);
    }

}
