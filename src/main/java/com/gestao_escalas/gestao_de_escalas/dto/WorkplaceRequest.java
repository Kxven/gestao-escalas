package com.gestao_escalas.gestao_de_escalas.dto;

import com.gestao_escalas.gestao_de_escalas.model.WorkplaceEntity;

public record WorkplaceRequest(String name,
                               AddressRequest adress) {
}
