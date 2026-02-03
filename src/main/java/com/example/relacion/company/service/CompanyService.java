package com.example.relacion.company.service;

import com.example.relacion.company.dto.CompanyDepartmentsDto;
import com.example.relacion.company.entity.Company;
import com.example.relacion.company.repository.CompanyRepository;
import com.example.relacion.department.dto.DepartmentEmployeesDto;
import com.example.relacion.department.entity.Department;
import com.example.relacion.department.repository.DepartmentRepository;
import com.example.relacion.employee.dto.EmployeeDto;
import com.example.relacion.employee.dto.EmployeesResponseDto;
import com.example.relacion.employee.entity.Employee;
import com.example.relacion.employee.mapper.EmployeeMapper;
import com.example.relacion.employee.repository.EmployeeRepository;
import com.example.relacion.exceptions.NotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;

    public CompanyService(CompanyRepository companyRepository, DepartmentRepository departmentRepository,
            EmployeeRepository employeeRepository) {
        this.companyRepository = companyRepository;
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
    }

    public CompanyDepartmentsDto obtenerDepartamentosEmpresa(Long companyId) {
        Company company = companyRepository.buscarPorIdYActivo(companyId, "S").orElse(null);
        if (company == null) {
            throw new NotFoundException("Company not found or inactive");
        }

        List<Department> departments = departmentRepository.buscarPorEmpresaIdYActivo(companyId, "S");
        departments.sort(Comparator.comparingLong(Department::getId));

        List<DepartmentEmployeesDto> departamentosDto = new ArrayList<>();
        double totalPresupuesto = 0.0;

        for (Department department : departments) {
            totalPresupuesto += department.getBudget();
            List<Employee> empleados = employeeRepository.buscarPorDepartamentoIdYActivo(
                    department.getId(), "S");
            List<EmployeeDto> empleadosDto = new ArrayList<>();
            for (Employee employee : empleados) {
                empleadosDto.add(EmployeeMapper.aDto(employee));
            }
            empleadosDto.sort(Comparator.comparingDouble(EmployeeDto::getSalary).reversed());
            DepartmentEmployeesDto deptoDto = new DepartmentEmployeesDto();
            deptoDto.setId(department.getId());
            deptoDto.setName(department.getName());
            deptoDto.setBudget(department.getBudget());
            deptoDto.setEmployees(empleadosDto);
            deptoDto.setEmployeeCount(empleadosDto.size());
            departamentosDto.add(deptoDto);
        }

        CompanyDepartmentsDto respuesta = new CompanyDepartmentsDto();
        respuesta.setCompanyId(company.getId());
        respuesta.setCompanyName(company.getName());
        respuesta.setCountry(company.getCountry());
        respuesta.setDepartmentCount(departamentosDto.size());
        respuesta.setDepartments(departamentosDto);
        respuesta.setTotalBudget(totalPresupuesto);
        return respuesta;
    }

    public EmployeesResponseDto obtenerEmpleadosAltoSalario(Long companyId, double minSalary) {
        Company company = companyRepository.buscarPorIdYActivo(companyId, "S").orElse(null);
        if (company == null) {
            throw new NotFoundException("Company not found or inactive");
        }

        List<Employee> empleados = employeeRepository.buscarEmpleadosConSalarioAlto(companyId, minSalary);
        List<EmployeeDto> empleadosDto = new ArrayList<>();
        for (Employee employee : empleados) {
            empleadosDto.add(EmployeeMapper.aDto(employee));
        }
        EmployeesResponseDto respuesta = new EmployeesResponseDto();
        respuesta.setCount(empleadosDto.size());
        respuesta.setEmployees(empleadosDto);
        return respuesta;
    }
}

