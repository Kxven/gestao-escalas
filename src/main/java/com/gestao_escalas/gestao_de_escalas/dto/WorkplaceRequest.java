package com.gestao_escalas.gestao_de_escalas.dto;

import com.gestao_escalas.gestao_de_escalas.model.WorkplaceEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record WorkplaceRequest(
        @NotBlank(message = "Name cannot be blank")
        String name,
        @NotNull(message = "Address is required")
        AddressRequest address) {}
