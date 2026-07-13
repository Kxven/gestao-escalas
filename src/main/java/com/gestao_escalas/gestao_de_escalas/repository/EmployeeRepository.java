package com.gestao_escalas.gestao_de_escalas.repository;

import com.gestao_escalas.gestao_de_escalas.dto.EmployeeResponse;
import com.gestao_escalas.gestao_de_escalas.model.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
    Optional<EmployeeEntity> findByEmail(String email);
    Optional<EmployeeEntity> findById(Long id);
}
