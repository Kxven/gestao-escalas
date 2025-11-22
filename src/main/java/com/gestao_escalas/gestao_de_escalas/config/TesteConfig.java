package com.gestao_escalas.gestao_de_escalas.config;

import com.gestao_escalas.gestao_de_escalas.model.Funcionario;
import com.gestao_escalas.gestao_de_escalas.model.enums.Funcao;
import com.gestao_escalas.gestao_de_escalas.model.enums.Turno;
import com.gestao_escalas.gestao_de_escalas.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner{
    @Autowired
    FuncionarioRepository funcionarioRepository;

    @Override
    public void run( String... args ) throws Exception{

        Funcionario f1 = new Funcionario("João Silva", Funcao.PORTEIRO, Turno.DIURNO, "Ipiranga", true);
        Funcionario f2 = new Funcionario( "Keven P", Funcao.VIGILANTE, Turno.NOTURNO, "Barra funda", false);

        funcionarioRepository.save(f1);
        funcionarioRepository.save(f2);
        System.out.println("Funcionarios adicionados!");
    }
}
