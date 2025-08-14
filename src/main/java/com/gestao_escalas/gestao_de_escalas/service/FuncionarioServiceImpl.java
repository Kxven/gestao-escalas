package com.gestao_escalas.gestao_de_escalas.service;

import com.gestao_escalas.gestao_de_escalas.model.Funcionario;
import com.gestao_escalas.gestao_de_escalas.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioServiceImpl implements FuncionarioService{

        private final FuncionarioRepository funcionarioRepository;

        public FuncionarioServiceImpl(FuncionarioRepository funcionarioRepository) {
            this.funcionarioRepository = funcionarioRepository;
        }

        @Override
        public Funcionario salvar( Funcionario funcionario) {
            return funcionarioRepository.save(funcionario);
        }

        @Override
        public List<Funcionario> listarTodos() {
            return funcionarioRepository.findAll();
        }

        @Override
        public Optional<Funcionario> buscarPorId( Long id) {
            return funcionarioRepository.findById(id);
        }

        @Override
        public void deletar(Long id) {
            funcionarioRepository.deleteById(id);
        }
    }

