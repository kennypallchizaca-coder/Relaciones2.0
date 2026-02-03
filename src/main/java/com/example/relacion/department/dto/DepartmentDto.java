package com.example.relacion.department.dto;

public class DepartmentDto {
    private Long id;
    private String name;
    private double budget;
    private String active;

    public DepartmentDto() {
    }

    public DepartmentDto(Long id, String name, double budget, String active) {
        this.id = id;
        this.name = name;
        this.budget = budget;
        this.active = active;
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

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }
}




