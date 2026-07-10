package com.gestao_escalas.gestao_de_escalas.dto;

public record AddressRequest(String street,
                             String number,
                             String city,
                             String state,
                             String zipcode
                           ) {
}
