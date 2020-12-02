package com.employee.management.EmployeeManagement.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class UserrolesPK implements Serializable {

    private int employeeId;
    private int roleId;

    @Id
    @Column(name = "roleId", nullable = false)
    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Id
    @Column(name = "employeeId", nullable = false)
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserrolesPK that = (UserrolesPK) o;
        return employeeId == that.employeeId &&
                roleId == that.roleId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, roleId);
    }
}
