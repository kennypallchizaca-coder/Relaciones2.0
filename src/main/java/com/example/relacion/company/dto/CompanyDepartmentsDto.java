package com.example.relacion.company.dto;

import com.example.relacion.department.dto.DepartmentEmployeesDto;
import java.util.ArrayList;
import java.util.List;

public class CompanyDepartmentsDto {
    private Long companyId;
    private String companyName;
    private String country;
    private long departmentCount;
    private List<DepartmentEmployeesDto> departments = new ArrayList<>();
    private double totalBudget;

    public CompanyDepartmentsDto() {
    }

    public CompanyDepartmentsDto(Long companyId, String companyName, String country, long departmentCount,
            List<DepartmentEmployeesDto> departments, double totalBudget) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.country = country;
        this.departmentCount = departmentCount;
        this.departments = departments;
        this.totalBudget = totalBudget;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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




