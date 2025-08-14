package com.gestao_escalas.gestao_de_escalas.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Funcionario{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;

    @Enumerated(EnumType.STRING)
    private Funcao funcao;

    @Enumerated(EnumType.STRING)
    private Turno turno;

    private String localizacao;

    private boolean disponibilidade;

}
