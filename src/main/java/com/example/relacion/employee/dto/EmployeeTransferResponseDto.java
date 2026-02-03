package com.example.relacion.employee.dto;

import com.example.relacion.department.dto.DepartmentSimpleDto;

public class EmployeeTransferResponseDto {
    private Long employeeId;
    private String employeeName;
    private DepartmentSimpleDto oldDepartment;
    private DepartmentSimpleDto newDepartment;
    private String message;

    public EmployeeTransferResponseDto() {
    }

    public EmployeeTransferResponseDto(Long employeeId, String employeeName, DepartmentSimpleDto oldDepartment,
            DepartmentSimpleDto newDepartment, String message) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.oldDepartment = oldDepartment;
        this.newDepartment = newDepartment;
        this.message = message;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public DepartmentSimpleDto getOldDepartment() {
        return oldDepartment;
    }

    public void setOldDepartment(DepartmentSimpleDto oldDepartment) {
        this.oldDepartment = oldDepartment;
    }

    public DepartmentSimpleDto getNewDepartment() {
        return newDepartment;
    }

    public void setNewDepartment(DepartmentSimpleDto newDepartment) {
        this.newDepartment = newDepartment;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}




