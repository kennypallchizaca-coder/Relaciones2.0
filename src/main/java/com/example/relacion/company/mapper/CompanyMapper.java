package com.example.relacion.company.mapper;

import com.example.relacion.company.dto.CompanyDto;
import com.example.relacion.company.entity.Company;

public final class CompanyMapper {
    
    private CompanyMapper() {
    }

    public static CompanyDto aDto(Company company) {
        if (company == null) {
            return null;
        }
        return new CompanyDto(company.getId(), company.getName(), company.getCountry(), company.getActive());
    }
}

