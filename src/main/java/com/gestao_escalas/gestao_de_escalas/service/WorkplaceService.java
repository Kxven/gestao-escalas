package com.gestao_escalas.gestao_de_escalas.service;

import com.gestao_escalas.gestao_de_escalas.dto.*;
import com.gestao_escalas.gestao_de_escalas.model.AddressEntity;
import com.gestao_escalas.gestao_de_escalas.model.WorkplaceEntity;
import com.gestao_escalas.gestao_de_escalas.repository.WorkPlaceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkplaceService {
    private final WorkPlaceRepository workPlaceRepository;

    public WorkplaceService(WorkPlaceRepository workPlaceRepository) {
        this.workPlaceRepository = workPlaceRepository;
    }

    public WorkplaceResponse registerWorkplace(WorkplaceRequest workplaceRequest){

        //Add address
        AddressEntity address = new AddressEntity();
        address.setStreet(workplaceRequest.address().street());
        address.setNumber(workplaceRequest.address().number());
        address.setCity(workplaceRequest.address().city());
        address.setState(workplaceRequest.address().state());
        address.setZipcode(workplaceRequest.address().zipcode());

        WorkplaceEntity workplace = new WorkplaceEntity();

        workplace.setName(workplaceRequest.name());
        workplace.setAddress(address);

        WorkplaceEntity savedWorkplace = workPlaceRepository.save(workplace);
        return WorkplaceResponse.from(savedWorkplace);
    }

    public WorkplaceResponse getById(Long id){
        WorkplaceEntity workplace = workPlaceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Workplace not found"));
        return WorkplaceResponse.from(workplace);
    }

    public List<WorkplaceResponse> getAllWorkplaces(){
        List<WorkplaceResponse> workplaces = workPlaceRepository.findAll()
                .stream()
                .map(WorkplaceResponse::from)
                .toList();
        return workplaces;
    }

    public WorkplaceResponse updateWorkplace(Long id, WorkplaceRequest workplaceRequest){
        WorkplaceEntity workplace = workPlaceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Workplace not found"));

        if(workplaceRequest.name() != null){
            workplace.setName(workplaceRequest.name());
        }

        if(workplaceRequest.address() != null){
            AddressEntity address = workplace.getAddress();

            if (address == null) {
                address = new AddressEntity();
            }

            if (workplaceRequest.address().street() != null) {
                address.setStreet(workplaceRequest.address().street());
            }

            if (workplaceRequest.address().number() != null) {
                address.setNumber(workplaceRequest.address().number());
            }

            if (workplaceRequest.address().city() != null) {
                address.setCity(workplaceRequest.address().city());
            }

            if (workplaceRequest.address().state() != null) {
                address.setState(workplaceRequest.address().state());
            }

            if (workplaceRequest.address().zipcode() != null) {
                address.setZipcode(workplaceRequest.address().zipcode());
            }

            workplace.setAddress(address);
        }

        WorkplaceEntity updateWorkplace = workPlaceRepository.save(workplace);
        return WorkplaceResponse.from(updateWorkplace);
    }

    public void deleteWorkplace(Long id){
        WorkplaceEntity worplace = workPlaceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Workplace not found!"));
        workPlaceRepository.delete(worplace);
    }

    public WorkplaceEmployeesResponse getWorkplaceWithEmployees(Long id){
        WorkplaceEntity workplace = workPlaceRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Workplace not found!"));

        List<EmployeeSumaryResponse> employees = workplace.getEmployees()
                .stream()
                .map(EmployeeSumaryResponse::from)
                .toList();
        return new WorkplaceEmployeesResponse(
                workplace.getId(),
                workplace.getName(),
                AddressResponse.from(workplace.getAddress()),
                employees
        );
    }

}
