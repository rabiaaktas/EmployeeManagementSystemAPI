package com.employee.management.EmployeeManagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.util.Objects;

@Entity
@IdClass(UserrolesPK.class)
public class Userroles {

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
        Userroles userroles = (Userroles) o;
        return employeeId == userroles.employeeId &&
                roleId == userroles.roleId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, roleId);
    }
}
