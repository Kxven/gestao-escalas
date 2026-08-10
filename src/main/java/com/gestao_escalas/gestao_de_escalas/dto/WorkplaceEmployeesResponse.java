package com.gestao_escalas.gestao_de_escalas.dto;

import java.util.List;

public record WorkplaceEmployeesResponse (Long id,
                                          String name,
                                          AddressResponse address,
                                          List<EmployeeSumaryResponse> employees){
}
