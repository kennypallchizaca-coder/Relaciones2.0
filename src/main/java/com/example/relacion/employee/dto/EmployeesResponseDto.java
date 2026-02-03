package com.example.relacion.employee.dto;

import java.util.ArrayList;
import java.util.List;

public class EmployeesResponseDto {
    private long count;
    private List<EmployeeDto> employees = new ArrayList<>();

    public EmployeesResponseDto() {
    }

    public EmployeesResponseDto(long count, List<EmployeeDto> employees) {
        this.count = count;
        this.employees = employees;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public List<EmployeeDto> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeDto> employees) {
        this.employees = employees;
    }
}




