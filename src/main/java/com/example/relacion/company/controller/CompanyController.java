package com.example.relacion.company.controller;

import com.example.relacion.company.dto.CompanyDepartmentsDto;
import com.example.relacion.company.service.CompanyService;
import com.example.relacion.employee.dto.EmployeesResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/{id}/departments")
    public CompanyDepartmentsDto obtenerDepartamentosEmpresa(@PathVariable("id") Long id) {
        return companyService.obtenerDepartamentosEmpresa(id);
    }

    @GetMapping("/{id}/high-salary-employees")
    public EmployeesResponseDto obtenerEmpleadosAltoSalario(@PathVariable("id") Long id,
            @RequestParam(value = "minSalary", required = false) Double minSalary) {
        double min = 5000.0;
        if (minSalary != null) {
            min = minSalary;
        }
        return companyService.obtenerEmpleadosAltoSalario(id, min);
    }
}

