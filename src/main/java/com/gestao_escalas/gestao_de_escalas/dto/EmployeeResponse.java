package com.gestao_escalas.gestao_de_escalas.dto;

import com.gestao_escalas.gestao_de_escalas.model.EmployeeEntity;
import com.gestao_escalas.gestao_de_escalas.model.enums.Shift;

public record EmployeeResponse(
                               Long id,
                               String name,
                               String email,
                               Shift shift,
                               AddressResponse address,
                               WorkplaceResponse workplace
) {
    public static EmployeeResponse from(EmployeeEntity employee) {
        return new EmployeeResponse(
                employee.getId(),
                employee.getName(),
                employee.getEmail(),
                employee.getShift(),
                AddressResponse.from(employee.getAddress()),
                WorkplaceResponse.from(employee.getWorkplace())
        );
    }
}
