package com.gestao_escalas.gestao_de_escalas.dto;

import com.gestao_escalas.gestao_de_escalas.model.AddressEntity;

public record AddressResponse(String street,
                              String number,
                              String city,
                              String state,
                              String zipcode) {
    public static AddressResponse from(AddressEntity address){
        return new AddressResponse(
            address.getStreet(),
            address.getNumber(),
            address.getCity(),
            address.getState(),
            address.getZipcode()
        );
    }
}

