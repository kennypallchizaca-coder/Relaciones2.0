package com.example.relacion.employee.dto;

public class EmployeeTransferResponseDto {
    private EmployeeDto employee;

    public EmployeeTransferResponseDto() {
    }

    public EmployeeTransferResponseDto(EmployeeDto employee) {
        this.employee = employee;
    }

    public EmployeeDto getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeDto employee) {
        this.employee = employee;
    }
}




