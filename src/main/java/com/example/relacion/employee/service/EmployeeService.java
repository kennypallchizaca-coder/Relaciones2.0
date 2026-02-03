package com.example.relacion.employee.service;

import com.example.relacion.department.entity.Department;
import com.example.relacion.department.repository.DepartmentRepository;
import com.example.relacion.employee.dto.EmployeeTransferResponseDto;
import com.example.relacion.employee.entity.Employee;
import com.example.relacion.employee.mapper.EmployeeMapper;
import com.example.relacion.employee.repository.EmployeeRepository;
import com.example.relacion.exceptions.ConflictException;
import com.example.relacion.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    public EmployeeService(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }

    public EmployeeTransferResponseDto transferirEmpleado(Long employeeId, Long newDepartmentId) {
        Employee employee = employeeRepository.buscarPorIdYActivo(employeeId, "S").orElse(null);
        if (employee == null) {
            throw new NotFoundException("Employee not found or inactive");
        }

        Department targetDepartment = departmentRepository.buscarPorIdYActivo(newDepartmentId, "S").orElse(null);
        if (targetDepartment == null) {
            throw new NotFoundException("Target department not found or inactive");
        }

        if (employee.getDepartment() != null && targetDepartment.getId().equals(employee.getDepartment().getId())) {
            throw new ConflictException("Employee is already in the target department");
        }

        employee.setDepartment(targetDepartment);
        Employee saved = employeeRepository.save(employee);
        EmployeeTransferResponseDto respuesta = new EmployeeTransferResponseDto();
        respuesta.setEmployee(EmployeeMapper.aDto(saved));
        return respuesta;
    }
}

