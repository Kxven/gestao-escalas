package com.gestao_escalas.gestao_de_escalas.model;

import com.gestao_escalas.gestao_de_escalas.model.enums.Turno;
import jakarta.persistence.*;
import com.gestao_escalas.gestao_de_escalas.model.enums.Funcao;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Funcionario{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Enumerated(EnumType.STRING)
    private Funcao funcao;

    @Enumerated(EnumType.STRING)
    private Turno turno;

    private String localizacao;

    private boolean disponibilidade;

    public Funcionario(String nome,Funcao funcao,Turno turno,String localizacao,boolean disponibilidade ){
        this.nome = nome;
        this.funcao = funcao;
        this.turno = turno;
        this.localizacao = localizacao;
        this.disponibilidade = true;
    }
}
