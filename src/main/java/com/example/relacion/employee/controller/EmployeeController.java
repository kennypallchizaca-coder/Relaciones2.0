package com.example.relacion.employee.controller;

import com.example.relacion.employee.dto.EmployeeTransferRequestDto;
import com.example.relacion.employee.dto.EmployeeTransferResponseDto;
import com.example.relacion.employee.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PatchMapping("/{employeeId}/transfer")
    public EmployeeTransferResponseDto transferirEmpleado(@PathVariable("employeeId") Long employeeId,
            @Valid @RequestBody EmployeeTransferRequestDto request) {
        return employeeService.transferirEmpleado(employeeId, request.getNewDepartmentId());
    }
}

