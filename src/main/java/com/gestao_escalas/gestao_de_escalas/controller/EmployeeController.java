package com.gestao_escalas.gestao_de_escalas.controller;

import com.gestao_escalas.gestao_de_escalas.dto.EmployeeRequest;
import com.gestao_escalas.gestao_de_escalas.dto.EmployeeResponse;
import com.gestao_escalas.gestao_de_escalas.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

}
