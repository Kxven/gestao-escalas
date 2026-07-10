package com.gestao_escalas.gestao_de_escalas.dto;

import com.gestao_escalas.gestao_de_escalas.model.WorkplaceEntity;

public record WorkplaceResponse(Long id,
                                String name,
                                AddressResponse address) {
    public static WorkplaceResponse from(WorkplaceEntity workplace){
        return new WorkplaceResponse(
                workplace.getId(),
                workplace.getName(),
                AddressResponse.from(workplace.getAddress())
        );
    }
}
