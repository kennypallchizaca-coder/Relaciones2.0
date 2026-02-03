package com.example.relacion.company.repository;

import com.example.relacion.company.entity.Company;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    @Query("select c from Company c where c.id = :id and c.active = :active")
    Optional<Company> buscarPorIdYActivo(@Param("id") Long id, @Param("active") String active);
}




