package com.employee.management.EmployeeManagement.model;

public class UserJobInformationDTO {

    private int employeeId;
    private String first_name;
    private String last_name;
    private String email;
    private String phone;
    private int jobId;
    private int departmentId;
    private String jobName;
    private String departmentName;
    private int managerId;


    public UserJobInformationDTO(int employeeId, String first_name, String last_name, String email, String phone,
                                 int jobId, int departmentId, String jobName, String departmentName, int managerId){
        this.employeeId = employeeId;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.phone = phone;
        this.jobId = jobId;
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.jobName = jobName;
        this.managerId = managerId;
    }
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }
}
