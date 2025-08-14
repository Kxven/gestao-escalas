package com.gestao_escalas.gestao_de_escalas.repository;

import com.gestao_escalas.gestao_de_escalas.model.Cobertura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoberturaRepository extends JpaRepository<Cobertura, Long>{}
