package com.example.relacion.department.repository;

import com.example.relacion.department.entity.Department;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    @Query("select d from Department d where d.id = :id and d.active = :active")
    Optional<Department> buscarPorIdYActivo(@Param("id") Long id, @Param("active") String active);

    @Query("select d from Department d where d.company.id = :companyId and d.active = :active")
    List<Department> buscarPorEmpresaIdYActivo(@Param("companyId") Long companyId,
            @Param("active") String active);
}




