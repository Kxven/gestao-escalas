package com.gestao_escalas.gestao_de_escalas.dto;

import com.gestao_escalas.gestao_de_escalas.model.enums.Shift;

public record EmployeeUpdateRequest(
        String name,
        String email,
        Shift shift,
        AddressRequest address,
        Long workplaceId
) {
}
