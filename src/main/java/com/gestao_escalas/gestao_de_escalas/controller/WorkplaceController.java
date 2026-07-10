package com.gestao_escalas.gestao_de_escalas.controller;

import com.gestao_escalas.gestao_de_escalas.dto.WorkplaceRequest;
import com.gestao_escalas.gestao_de_escalas.dto.WorkplaceResponse;
import com.gestao_escalas.gestao_de_escalas.repository.WorkPlaceRepository;
import com.gestao_escalas.gestao_de_escalas.service.WorkplaceService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/workplaces")
public class WorkplaceController {
    private final WorkplaceService workplaceService;

    public WorkplaceController(WorkplaceService workplaceService) {
        this.workplaceService = workplaceService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public WorkplaceResponse registerWorkplace(@RequestBody WorkplaceRequest workplaceRequest){
        return workplaceService.registerWorkplace(workplaceRequest);
    }
}
