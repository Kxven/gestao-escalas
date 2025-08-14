package com.gestao_escalas.gestao_de_escalas.model;

import com.gestao_escalas.gestao_de_escalas.model.enums.StatusCobertura;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cobertura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dataSolicitacao;

    @Enumerated(EnumType.STRING)
    private StatusCobertura status;

    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionario;

    @ManyToOne
    @JoinColumn(name = "escala_id")
    private Escala escalaOriginal;
}
