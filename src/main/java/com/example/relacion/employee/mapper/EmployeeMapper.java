package com.example.relacion.employee.mapper;

import com.example.relacion.employee.dto.EmployeeDto;
import com.example.relacion.employee.entity.Employee;

public final class EmployeeMapper {
    private EmployeeMapper() {
    }

    public static EmployeeDto aDto(Employee employee) {
        if (employee == null) {
            return null;
        }
        Long departmentId = null;
        if (employee.getDepartment() != null) {
            departmentId = employee.getDepartment().getId();
        }
        EmployeeDto dto = new EmployeeDto();
        dto.setId(employee.getId());
        dto.setFirstName(employee.getFirstName());
        dto.setLastName(employee.getLastName());
        dto.setEmail(employee.getEmail());
        dto.setSalary(employee.getSalary());
        dto.setDepartmentId(departmentId);
        return dto;
    }
}

