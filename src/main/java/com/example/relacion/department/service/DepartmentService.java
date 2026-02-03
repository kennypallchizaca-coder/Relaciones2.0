package com.example.relacion.department.service;

import com.example.relacion.department.dto.DepartmentWithEmployeesDto;
import com.example.relacion.company.mapper.CompanyMapper;
import com.example.relacion.department.entity.Department;
import com.example.relacion.department.repository.DepartmentRepository;
import com.example.relacion.employee.dto.EmployeeDto;
import com.example.relacion.employee.entity.Employee;
import com.example.relacion.employee.mapper.EmployeeMapper;
import com.example.relacion.employee.repository.EmployeeRepository;
import com.example.relacion.exceptions.NotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;

    public DepartmentService(DepartmentRepository departmentRepository, EmployeeRepository employeeRepository) {
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
    }

    @Transactional(readOnly = true)
    public DepartmentWithEmployeesDto obtenerDepartamentoConEmpleados(Long departmentId, String sort) {
        Department department = departmentRepository.buscarPorIdYActivo(departmentId, "S").orElse(null);
        if (department == null) {
            throw new NotFoundException("Department not found or inactive");
        }

        List<Employee> empleados = employeeRepository.buscarPorDepartamentoIdYActivo(departmentId, "S");
        List<EmployeeDto> empleadosDto = new ArrayList<>();
        double totalSalarios = 0.0;

        for (Employee employee : empleados) {
            empleadosDto.add(EmployeeMapper.aDto(employee));
            totalSalarios += employee.getSalary();
        }

        String orden = sort == null ? "desc" : sort.trim().toLowerCase();
        Comparator<EmployeeDto> comparador = Comparator.comparingDouble(EmployeeDto::getSalary);
        if (!"asc".equals(orden)) {
            comparador = comparador.reversed();
        }
        empleadosDto.sort(comparador);

        DepartmentWithEmployeesDto respuesta = new DepartmentWithEmployeesDto();
        respuesta.setId(department.getId());
        respuesta.setName(department.getName());
        respuesta.setBudget(department.getBudget());
        respuesta.setCompany(CompanyMapper.aDto(department.getCompany()));
        respuesta.setEmployees(empleadosDto);
        respuesta.setEmployeeCount(empleadosDto.size());
        respuesta.setTotalSalaries(totalSalarios);
        return respuesta;
    }
}
