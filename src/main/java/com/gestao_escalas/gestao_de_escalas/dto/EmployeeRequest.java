package com.gestao_escalas.gestao_de_escalas.dto;

import com.gestao_escalas.gestao_de_escalas.model.AddressEntity;
import com.gestao_escalas.gestao_de_escalas.model.WorkplaceEntity;
import com.gestao_escalas.gestao_de_escalas.model.enums.Shift;

public record EmployeeRequest(String name,
                              String email,
                              Shift shift,
                              AddressRequest address,
                              Long workplaceId){
}
