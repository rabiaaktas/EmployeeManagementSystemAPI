package com.employee.management.EmployeeManagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "Employees", schema = "employee_management")
public class Employees {


    private int employeeID;
    private String first_name;
    private String last_name;
    private String email;
    private String phone;
    private Date hireDate;
    private int jobId;
    private double salary;
    private int managerId;
    private int departmentId;
    private Byte isActive;

    @Id
    @Column(name = "employeeID", nullable = false)
    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }
}
