package com.gestao_escalas.gestao_de_escalas.dto;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.engine.spi.ManagedEntity;

public record AddressRequest(
        @NotBlank(message = "Street is required")
        String street,
        @NotBlank(message = "Number is required")
        String number,
        @NotBlank(message = "City is required")
        String city,
        @NotBlank(message = "State is required")
        String state,
        @NotBlank(message = "Zipcode is required")
        String zipcode
                           ) {}
