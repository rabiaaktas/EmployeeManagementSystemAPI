package com.employee.management.EmployeeManagement.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "managers")
public class Managers {

    private int managerId;
    private int employeeId;
    private Byte isActive;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "managerID", nullable = false)
    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    @Basic
    @Column(name = "employeeId", nullable = false)
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    @Basic
    @Column(name = "isActive", nullable = false)
    public Byte getIsActive() {
        return isActive;
    }

    public void setIsActive(Byte isActive) {
        this.isActive = isActive;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Managers managers = (Managers) o;
        return managerId == managers.managerId &&
                Objects.equals(employeeId, managers.employeeId) &&
                Objects.equals(isActive, managers.isActive);
    }

    @Override
    public int hashCode() {
        return Objects.hash(managerId, employeeId, isActive);
    }
}
