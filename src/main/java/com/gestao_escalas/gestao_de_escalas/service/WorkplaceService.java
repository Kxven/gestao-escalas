package com.gestao_escalas.gestao_de_escalas.service;

import com.gestao_escalas.gestao_de_escalas.dto.WorkplaceRequest;
import com.gestao_escalas.gestao_de_escalas.dto.WorkplaceResponse;
import com.gestao_escalas.gestao_de_escalas.model.AddressEntity;
import com.gestao_escalas.gestao_de_escalas.model.WorkplaceEntity;
import com.gestao_escalas.gestao_de_escalas.repository.WorkPlaceRepository;
import org.springframework.stereotype.Service;

@Service
public class WorkplaceService {
    private final WorkPlaceRepository workPlaceRepository;

    public WorkplaceService(WorkPlaceRepository workPlaceRepository) {
        this.workPlaceRepository = workPlaceRepository;
    }

    public WorkplaceResponse registerWorkplace(WorkplaceRequest workplaceRequest){

        //Add address
        AddressEntity address = new AddressEntity();
        address.setStreet(workplaceRequest.adress().street());
        address.setNumber(workplaceRequest.adress().number());
        address.setCity(workplaceRequest.adress().city());
        address.setState(workplaceRequest.adress().state());
        address.setZipcode(workplaceRequest.adress().zipcode());

        WorkplaceEntity workplace = new WorkplaceEntity();

        workplace.setName(workplaceRequest.name());
        workplace.setAddress(address);

        WorkplaceEntity savedWorkplace = workPlaceRepository.save(workplace);
        return WorkplaceResponse.from(savedWorkplace);
    }

}
