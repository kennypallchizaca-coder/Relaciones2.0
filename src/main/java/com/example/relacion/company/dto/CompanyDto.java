package com.example.relacion.company.dto;

public class CompanyDto {
    private Long id;
    private String name;
    private String country;
    private String active;

    public CompanyDto() {
    }

    public CompanyDto(Long id, String name, String country, String active) {
        this.id = id;
        this.name = name;
        this.country = country;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }
}




