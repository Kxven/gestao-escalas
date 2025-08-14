package com.gestao_escalas.gestao_de_escalas.repository;

import com.gestao_escalas.gestao_de_escalas.model.Condominio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CondominioRepository extends JpaRepository<Condominio, Long>{}
