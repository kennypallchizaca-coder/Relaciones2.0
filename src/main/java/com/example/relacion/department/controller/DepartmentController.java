package com.example.relacion.department.controller;

import com.example.relacion.department.dto.DepartmentWithEmployeesDto;
import com.example.relacion.department.service.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/{id}/employees")
    public DepartmentWithEmployeesDto obtenerEmpleadosDepartamento(@PathVariable("id") Long id,
            @RequestParam(name = "sort", defaultValue = "desc") String sort) {
        return departmentService.obtenerDepartamentoConEmpleados(id, sort);
    }
}

