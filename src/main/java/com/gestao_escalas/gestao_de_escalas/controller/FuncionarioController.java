package com.gestao_escalas.gestao_de_escalas.controller;

import com.gestao_escalas.gestao_de_escalas.model.Funcionario;
import com.gestao_escalas.gestao_de_escalas.service.FuncionarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController{

    private final FuncionarioService funcionarioService;

        public FuncionarioController(FuncionarioService funcionarioService) {
            this.funcionarioService = funcionarioService;
        }

        @PostMapping
        public ResponseEntity<Funcionario> salvar( @RequestBody Funcionario funcionario) {
            return ResponseEntity.ok(funcionarioService.salvar(funcionario));
        }

        @GetMapping
        public ResponseEntity<List<Funcionario>> listarTodos() {
            return ResponseEntity.ok(funcionarioService.listarTodos());
        }

        @GetMapping("/{id}")
        public ResponseEntity<Funcionario> buscarPorId(@PathVariable Long id) {
            return funcionarioService.buscarPorId(id)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deletar(@PathVariable Long id) {
            funcionarioService.deletar(id);
            return ResponseEntity.noContent().build();
        }
}

