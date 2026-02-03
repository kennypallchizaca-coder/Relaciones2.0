package com.example.relacion.employee.repository;

import com.example.relacion.employee.entity.Employee;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query("select e from Employee e where e.id = :id and e.active = :active")
    Optional<Employee> buscarPorIdYActivo(@Param("id") Long id, @Param("active") String active);

    @Query("select e from Employee e where e.department.id = :departmentId and e.active = :active")
    List<Employee> buscarPorDepartamentoIdYActivo(@Param("departmentId") Long departmentId,
            @Param("active") String active);

    @Query("select e from Employee e join e.department d join d.company c "
            + "where c.id = :companyId and c.active = 'S' and d.active = 'S' and e.active = 'S' "
            + "and e.salary >= :minSalary order by e.salary desc")
    List<Employee> buscarEmpleadosConSalarioAlto(@Param("companyId") Long companyId,
            @Param("minSalary") double minSalary);
}




