package com.employee.management.EmployeeManagement.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "jobs", schema = "employee_management")
public class Jobs {

    private int jobId;
    private String jobName;
    private double minSalary;
    private double maxSalary;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "jobID", nullable = false)
    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    @Basic
    @Column(name = "job_title", length = 255)
    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    @Basic
    @Column(name = "min_salary")
    public double getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(double minSalary) {
        this.minSalary = minSalary;
    }

    @Basic
    @Column(name = "max_salary")
    public double getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(double maxSalary) {
        this.maxSalary = maxSalary;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Jobs jobs = (Jobs) o;
        return jobId == jobs.jobId &&
                Objects.equals(jobName, jobs.jobName) &&
                Objects.equals(minSalary, jobs.minSalary) &&
                Objects.equals(maxSalary, jobs.maxSalary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jobId, jobName, minSalary, maxSalary);
    }
}
