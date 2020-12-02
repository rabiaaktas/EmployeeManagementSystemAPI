package com.employee.management.EmployeeManagement.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "job_history")
public class JobHistory {

    private int jHistoryId;
    private int employeeId;
    private Date startDate;
    private Date endDate;
    private int jobId;
    private int departmentId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "j_historyID", nullable = false)
    public int getjHistoryId() {
        return jHistoryId;
    }

    public void setjHistoryId(int jHistoryId) {
        this.jHistoryId = jHistoryId;
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
    @Column(name = "start_date")
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "end_date")
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        JobHistory jobHistory = (JobHistory) o;
        return jHistoryId == jobHistory.jHistoryId &&
                Objects.equals(employeeId, jobHistory.employeeId) &&
                Objects.equals(startDate, jobHistory.startDate) &&
                Objects.equals(endDate, jobHistory.endDate) &&
                Objects.equals(jobId, jobHistory.jobId) &&
                Objects.equals(departmentId, jobHistory.departmentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jHistoryId, employeeId, startDate, endDate, jobId, departmentId);
    }
}
