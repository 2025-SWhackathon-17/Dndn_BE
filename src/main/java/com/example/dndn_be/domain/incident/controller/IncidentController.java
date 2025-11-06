package com.example.dndn_be.domain.incident.controller;

import com.example.dndn_be.domain.incident.dto.request.IncidentRequest;
import com.example.dndn_be.domain.incident.service.CreateIncidentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/incident")
@RequiredArgsConstructor
public class IncidentController {
    private final CreateIncidentService createIncidentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createIncident(@RequestBody @Valid IncidentRequest request) {
        createIncidentService.execute(request);
    }
}
