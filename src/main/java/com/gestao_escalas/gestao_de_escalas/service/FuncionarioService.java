package com.gestao_escalas.gestao_de_escalas.service;

import com.gestao_escalas.gestao_de_escalas.model.Funcionario;

import java.util.List;
import java.util.Optional;

public interface FuncionarioService {
    Funcionario salvar( Funcionario funcionario);
    List<Funcionario> listarTodos();
    Optional<Funcionario> buscarPorId( Long id);
    void deletar(Long id);
}

