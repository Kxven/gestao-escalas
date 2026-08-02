package com.gestao_escalas.gestao_de_escalas.dto;

import com.gestao_escalas.gestao_de_escalas.model.AddressEntity;
import com.gestao_escalas.gestao_de_escalas.model.EmployeeEntity;
import com.gestao_escalas.gestao_de_escalas.model.enums.Shift;

public record EmployeeSumaryResponse(Long id, String name, String email, Shift shift, String address) {
    public static EmployeeSumaryResponse from(EmployeeEntity employee){

        AddressEntity address = employee.getAddress();
        String formattedAddress = address.getStreet()
                + ", " + address.getNumber()
                + ", " + address.getCity()
                + ", " + address.getState()
                + ", " + address.getZipcode();

         return new EmployeeSumaryResponse(
                employee.getId(),
                employee.getName(),
                employee.getEmail(),
                employee.getShift(),
                 formattedAddress
        );
    }
}