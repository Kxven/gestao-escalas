package com.gestao_escalas.gestao_de_escalas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressEntity {

    private String street;
    private String number;
    private String city;
    private String state;
    private String zipcode;
}
