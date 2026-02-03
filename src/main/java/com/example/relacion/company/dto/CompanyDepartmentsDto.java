package com.example.relacion.company.dto;

import com.example.relacion.department.dto.DepartmentEmployeesDto;
import java.util.ArrayList;
import java.util.List;

public class CompanyDepartmentsDto {
    private CompanyDto company;
    private long departmentCount;
    private List<DepartmentEmployeesDto> departments = new ArrayList<>();
    private double totalBudget;

    public CompanyDepartmentsDto() {
    }

    public CompanyDepartmentsDto(CompanyDto company, long departmentCount, List<DepartmentEmployeesDto> departments,
            double totalBudget) {
        this.company = company;
        this.departmentCount = departmentCount;
        this.departments = departments;
        this.totalBudget = totalBudget;
    }

    public CompanyDto getCompany() {
        return company;
    }

    public void setCompany(CompanyDto company) {
        this.company = company;
    }

    public long getDepartmentCount() {
        return departmentCount;
    }

    public void setDepartmentCount(long departmentCount) {
        this.departmentCount = departmentCount;
    }

    public List<DepartmentEmployeesDto> getDepartments() {
        return departments;
    }

    public void setDepartments(List<DepartmentEmployeesDto> departments) {
        this.departments = departments;
    }

    public double getTotalBudget() {
        return totalBudget;
    }

    public void setTotalBudget(double totalBudget) {
        this.totalBudget = totalBudget;
    }
}




