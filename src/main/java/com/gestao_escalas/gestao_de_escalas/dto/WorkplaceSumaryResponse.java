package com.gestao_escalas.gestao_de_escalas.dto;

import com.gestao_escalas.gestao_de_escalas.model.AddressEntity;
import com.gestao_escalas.gestao_de_escalas.model.WorkplaceEntity;

public record WorkplaceSumaryResponse(Long id, String name, String address) {
    public static WorkplaceSumaryResponse from(WorkplaceEntity workplace){
        AddressEntity address = workplace.getAddress();

        String formattedAddress = address.getStreet()
                + ", " + address.getNumber()
                + ", " + address.getCity()
                + ", " + address.getState()
                + ", " +  address.getZipcode();

        return new WorkplaceSumaryResponse(
                workplace.getId(),
                workplace.getName(),
                formattedAddress
        );
    }
}
