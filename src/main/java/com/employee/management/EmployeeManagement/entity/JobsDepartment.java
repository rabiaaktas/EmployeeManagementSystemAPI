package com.employee.management.EmployeeManagement.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "jobs_department", schema = "employee_management")
public class JobsDepartment {

    private int jobDepartmentID;
    private int jobId;
    private int departmentId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "jobDepartmentID")
    public int getJobDepartmentID() {
        return jobDepartmentID;
    }

    public void setJobDepartmentID(int jobDepartmentID) {
        this.jobDepartmentID = jobDepartmentID;
    }

    @Basic
    @Column(name = "jobId")
    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    @Basic
    @Column(name = "departmentId")
    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        JobsDepartment departments = (JobsDepartment) o;
        return jobDepartmentID == departments.jobDepartmentID &&
                Objects.equals(jobId, departments.jobId) &&
                Objects.equals(departmentId, departments.departmentId) ;
    }

    @Override
    public int hashCode(){
        return Objects.hash(jobDepartmentID, jobId, departmentId);
    }
}
