package com.gestao_escalas.gestao_de_escalas.controller;

import com.gestao_escalas.gestao_de_escalas.dto.EmployeeRequest;
import com.gestao_escalas.gestao_de_escalas.dto.EmployeeResponse;
import com.gestao_escalas.gestao_de_escalas.dto.EmployeeUpdateRequest;
import com.gestao_escalas.gestao_de_escalas.service.EmployeeService;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeResponse registerEmployee(@RequestBody EmployeeRequest employee) {
        return employeeService.registerEmployee(employee);
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EmployeeResponse getById(@PathVariable Long id){
        return employeeService.getById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<EmployeeResponse> getAllEmployees(){
        return  employeeService.getAllEmployees();
    }


    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EmployeeResponse updateEmployee(@PathVariable Long id, @RequestBody EmployeeUpdateRequest employee){
        return employeeService.updateEmployee(id, employee);
    }
}
