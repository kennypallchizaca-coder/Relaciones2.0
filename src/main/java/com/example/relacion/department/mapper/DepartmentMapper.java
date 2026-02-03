package com.example.relacion.department.mapper;

import com.example.relacion.department.dto.DepartmentDto;
import com.example.relacion.department.entity.Department;

public final class DepartmentMapper {
    private DepartmentMapper() {
    }

    public static DepartmentDto aDto(Department department) {
        if (department == null) {
            return null;
        }
        DepartmentDto dto = new DepartmentDto();
        dto.setId(department.getId());
        dto.setName(department.getName());
        dto.setBudget(department.getBudget());
        dto.setActive(department.getActive());
        return dto;
    }
}

