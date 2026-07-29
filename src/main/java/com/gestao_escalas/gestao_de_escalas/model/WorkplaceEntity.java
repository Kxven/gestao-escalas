package com.gestao_escalas.gestao_de_escalas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "tb_workplace")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class WorkplaceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Embedded
    private AddressEntity address;

    @OneToMany(mappedBy = "workplace")
    private List<EmployeeEntity> employees;
}
