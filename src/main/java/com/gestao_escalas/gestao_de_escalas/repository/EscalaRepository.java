package com.gestao_escalas.gestao_de_escalas.repository;

import com.gestao_escalas.gestao_de_escalas.model.Escala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EscalaRepository extends JpaRepository<Escala, Long>{}
