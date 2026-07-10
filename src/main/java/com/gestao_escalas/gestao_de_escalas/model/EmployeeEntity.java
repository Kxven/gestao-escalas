package com.gestao_escalas.gestao_de_escalas.model;

import com.gestao_escalas.gestao_de_escalas.model.enums.Shift;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_employee")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    private Shift shift;

    @Embedded
    private AddressEntity address;

    @ManyToOne
    @JoinColumn(name = "workplace_id")
    private WorkplaceEntity workplace;

}
