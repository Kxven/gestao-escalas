package com.gestao_escalas.gestao_de_escalas.dto;

import com.gestao_escalas.gestao_de_escalas.model.enums.Shift;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EmployeeRequest(
        @NotBlank(message = "Name cannot be blank!")
        String name,
        @NotBlank(message = "Email cannot be blank!")
        @Email(message = "Email must be valid!")
        String email,
        @NotNull(message = "Shift is required")
        Shift shift,
        @NotNull(message = "Address is required")
        AddressRequest address,
        @NotNull(message = "Workplace is required")
        Long workplaceId){}
