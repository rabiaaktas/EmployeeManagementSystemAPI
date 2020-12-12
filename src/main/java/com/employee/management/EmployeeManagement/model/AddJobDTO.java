package com.employee.management.EmployeeManagement.model;

public class AddJobDTO {

    private int jobId;
    private String jobName;
    private double minSalary;
    private double maxSalary;
    private int departmentId;

    public AddJobDTO(int jobId, String jobName, double minSalary, double maxSalary, int departmentId){
        this.jobId = jobId;
        this.jobName = jobName;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
        this.departmentId = departmentId;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public double getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(double minSalary) {
        this.minSalary = minSalary;
    }

    public double getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(double maxSalary) {
        this.maxSalary = maxSalary;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

}
