package com.employee.management.EmployeeManagement.model;

public class UserrolesDTO {

    private int employeeId;
    private int roleId;

    public UserrolesDTO(){

    }

    public UserrolesDTO(int employeeId, int roleId){
        this.employeeId = employeeId;
        this.roleId = roleId;
    }
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

}
