package com.example.relacion.department.dto;

import com.example.relacion.employee.dto.EmployeeDto;
import java.util.ArrayList;
import java.util.List;

public class DepartmentEmployeesDto {
    private Long id;
    private String name;
    private double budget;
    private List<EmployeeDto> employees = new ArrayList<>();
    private long employeeCount;

    public DepartmentEmployeesDto() {
    }

    public DepartmentEmployeesDto(Long id, String name, double budget, List<EmployeeDto> employees,
            long employeeCount) {
        this.id = id;
        this.name = name;
        this.budget = budget;
        this.employees = employees;
        this.employeeCount = employeeCount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public List<EmployeeDto> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeDto> employees) {
        this.employees = employees;
    }

    public long getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(long employeeCount) {
        this.employeeCount = employeeCount;
    }
}




