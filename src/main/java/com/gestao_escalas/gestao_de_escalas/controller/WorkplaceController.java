package com.gestao_escalas.gestao_de_escalas.controller;

import com.gestao_escalas.gestao_de_escalas.dto.WorkplaceRequest;
import com.gestao_escalas.gestao_de_escalas.dto.WorkplaceResponse;
import com.gestao_escalas.gestao_de_escalas.service.WorkplaceService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<WorkplaceResponse> getAllWorkplaces(){
        return workplaceService.getAllWorkplaces();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public WorkplaceResponse getById(@PathVariable Long id){
        return workplaceService.getById(id);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public WorkplaceResponse updateWorkplace(@PathVariable Long id, @RequestBody WorkplaceRequest workplaceRequest){
        return workplaceService.updateWorkplace(id, workplaceRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteWorkplace(@PathVariable Long id){
        workplaceService.deleteWorkplace(id);
    }
}
