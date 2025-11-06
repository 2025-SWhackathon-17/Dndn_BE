package com.example.dndn_be.domain.incident.controller;

import com.example.dndn_be.domain.incident.dto.request.IncidentRequest;
import com.example.dndn_be.domain.incident.dto.response.IncidentResponse;
import com.example.dndn_be.domain.incident.service.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/incident")
@RequiredArgsConstructor
public class IncidentController {
    private final CreateIncidentService createIncidentService;
    private final QueryIncidentDetailService queryIncidentDetailService;
    private final QueryAllIncidentService queryAllIncidentService;
    private final UpdateIncidentService updateIncidentService;
    private final DeleteIncidentService deleteIncidentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createIncident(@RequestBody @Valid IncidentRequest request) {
        createIncidentService.execute(request);
    }

    @GetMapping("/{incident-id}")
    @ResponseStatus(HttpStatus.OK)
    public IncidentResponse queryIncident(@PathVariable("incident-id") Long incidentId) {
        return queryIncidentDetailService.execute(incidentId);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<IncidentResponse> queryAllIncident() {
        return queryAllIncidentService.execute();
    }

    @PatchMapping("/{incident-id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateIncident(@PathVariable("incident-id") Long incidentId, @RequestBody @Valid IncidentRequest request) {
        updateIncidentService.execute(incidentId, request);
    }

    @DeleteMapping("/{incident-id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteIncident(@PathVariable("incident-id") Long incidentId) {
        deleteIncidentService.execute(incidentId);
    }
}
