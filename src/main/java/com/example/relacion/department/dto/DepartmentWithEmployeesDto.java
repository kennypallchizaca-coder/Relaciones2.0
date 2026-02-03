package com.example.relacion.department.dto;

import com.example.relacion.company.dto.CompanyDto;
import com.example.relacion.employee.dto.EmployeeDto;
import java.util.ArrayList;
import java.util.List;

public class DepartmentWithEmployeesDto {
    private Long id;
    private String name;
    private double budget;
    private CompanyDto company;
    private List<EmployeeDto> employees = new ArrayList<>();
    private long employeeCount;
    private double totalSalaries;

    public DepartmentWithEmployeesDto() {
    }

    public DepartmentWithEmployeesDto(Long id, String name, double budget, CompanyDto company,
            List<EmployeeDto> employees, long employeeCount, double totalSalaries) {
        this.id = id;
        this.name = name;
        this.budget = budget;
        this.company = company;
        this.employees = employees;
        this.employeeCount = employeeCount;
        this.totalSalaries = totalSalaries;
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

    public CompanyDto getCompany() {
        return company;
    }

    public void setCompany(CompanyDto company) {
        this.company = company;
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

    public double getTotalSalaries() {
        return totalSalaries;
    }

    public void setTotalSalaries(double totalSalaries) {
        this.totalSalaries = totalSalaries;
    }
}




