package com.employee.management.EmployeeManagement.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "Employees", schema = "employee_management")
public class Employees {


    private int employeeID;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private Date hireDate;
    private int jobId;
    private double salary;
    private int managerId;
    private int departmentId;
    private Byte isActive;
    private String password;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employeeID", nullable = false)
    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    @Basic
    @Column(name = "first_name", nullable = false, length = 200)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String first_name) {
        this.firstName = first_name;
    }

    @Basic
    @Column(name = "last_name", nullable = false, length = 200)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String last_name) {
        this.lastName = last_name;
    }

    @Basic
    @Column(name = "email_employee", nullable = false, length = 255)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "phone_number", nullable = true, length = 15)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "hire_date", nullable = true)
    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    @Basic
    @Column(name = "jobId", nullable = false)
    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    @Basic
    @Column(name = "salary", nullable = true)
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
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
    @Column(name = "departmentId")
    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    @Basic
    @Column(name = "isActive", nullable = false)
    public Byte getIsActive() {
        return isActive;
    }

    public void setIsActive(Byte isActive) {
        this.isActive = isActive;
    }

    @Basic
    @Column(name = "password", nullable = true, length = -1)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Employees employees = (Employees) o;
        return employeeID == employees.employeeID &&
                Objects.equals(firstName, employees.firstName) &&
                Objects.equals(lastName, employees.lastName) &&
                Objects.equals(email, employees.email) &&
                Objects.equals(phone, employees.phone) &&
                Objects.equals(hireDate, employees.hireDate) &&
                Objects.equals(jobId, employees.jobId) &&
                Objects.equals(salary, employees.salary) &&
                Objects.equals(managerId, employees.managerId) &&
                Objects.equals(departmentId, employees.departmentId) &&
                Objects.equals(isActive, employees.isActive) &&
                Objects.equals(password, employees.password);

    }

    @Override
    public int hashCode(){
        return Objects.hash(employeeID, firstName, lastName, email, phone, hireDate, jobId, salary, managerId, departmentId,
                isActive, password);
    }
}
