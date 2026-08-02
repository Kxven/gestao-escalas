package com.gestao_escalas.gestao_de_escalas.service;

import com.gestao_escalas.gestao_de_escalas.dto.*;
import com.gestao_escalas.gestao_de_escalas.model.AddressEntity;
import com.gestao_escalas.gestao_de_escalas.model.EmployeeEntity;
import com.gestao_escalas.gestao_de_escalas.model.WorkplaceEntity;
import com.gestao_escalas.gestao_de_escalas.repository.EmployeeRepository;
import com.gestao_escalas.gestao_de_escalas.repository.WorkPlaceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final WorkPlaceRepository workPlaceRepository;

    public EmployeeService(EmployeeRepository employeeRepository, WorkPlaceRepository workPlaceRepository) {
        this.employeeRepository = employeeRepository;
        this.workPlaceRepository = workPlaceRepository;
    }

    public EmployeeResponse registerEmployee(EmployeeRequest employeeRequest){
        EmployeeEntity employeeExists = employeeRepository.findByEmail(employeeRequest.email()).orElse(null);
        //Search workplace with id
        WorkplaceEntity workplace = workPlaceRepository
                .findById(employeeRequest.workplaceId())
                .orElseThrow(() -> new RuntimeException("Workplace not found"));
        //check if exists employee
        if (employeeExists != null){
            throw new RuntimeException("This email already exists");
        }

        //Adress
        AddressEntity address = new AddressEntity();
        address.setStreet(employeeRequest.address().street());
        address.setNumber(employeeRequest.address().number());
        address.setCity(employeeRequest.address().city());
        address.setState(employeeRequest.address().state());
        address.setZipcode(employeeRequest.address().zipcode());

        EmployeeEntity employee = new EmployeeEntity();
        employee.setName(employeeRequest.name());
        employee.setEmail(employeeRequest.email());
        employee.setShift(employeeRequest.shift());
        employee.setAddress(address);

        employee.setWorkplace(workplace);
        EmployeeEntity savedEmployee = employeeRepository.save(employee);
        return EmployeeResponse.from(savedEmployee);
    }

    public EmployeeResponse getById(Long id){
        EmployeeEntity employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        return EmployeeResponse.from(employee);
    }

    public List<EmployeeResponse> getAllEmployees(){
         List<EmployeeResponse> employees = employeeRepository.findAll()
                 .stream()
                 .map(EmployeeResponse::from)
                 .toList();
         return employees;
    }

    public EmployeeResponse updateEmployee(Long id, EmployeeUpdateRequest employeeRequest){
        EmployeeEntity employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        if(employeeRequest.name() != null){
            employee.setName(employeeRequest.name());
        }

        if(employeeRequest.email() != null) {
            employee.setEmail(employeeRequest.email());
        }

        if(employeeRequest.shift() != null){
            employee.setShift(employeeRequest.shift());
        }

        if (employeeRequest.workplaceId() != null){
            //Search workplace with id
            WorkplaceEntity workplace = workPlaceRepository
                    .findById(employeeRequest.workplaceId())
                    .orElseThrow(() -> new RuntimeException("Workplace not found"));

            employee.setWorkplace(workplace);
        }

        if(employeeRequest.address() != null){
            AddressEntity address = employee.getAddress();
            if (address == null) {
                address = new AddressEntity();
            }

            if (employeeRequest.address().street() != null) {
                address.setStreet(employeeRequest.address().street());
            }

            if (employeeRequest.address().number() != null) {
                address.setNumber(employeeRequest.address().number());
            }

            if (employeeRequest.address().city() != null) {
                address.setCity(employeeRequest.address().city());
            }

            if (employeeRequest.address().state() != null) {
                address.setState(employeeRequest.address().state());
            }

            if (employeeRequest.address().zipcode() != null) {
                address.setZipcode(employeeRequest.address().zipcode());
            }

            employee.setAddress(address);
        }
        EmployeeEntity updateEmployee = employeeRepository.save(employee);

        return EmployeeResponse.from(updateEmployee);
    }

    public void deleteById(Long id){
        EmployeeEntity employee = employeeRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        employeeRepository.delete(employee);
    }

    public EmployeeWorkplaceResponse getEmployeeWorkplace(Long id){
        EmployeeEntity employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        return new EmployeeWorkplaceResponse(
                EmployeeSumaryResponse.from(employee),
                WorkplaceSumaryResponse.from(employee.getWorkplace())
        );
    }
}
