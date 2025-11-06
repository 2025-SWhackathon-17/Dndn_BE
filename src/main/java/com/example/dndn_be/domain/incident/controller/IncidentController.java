package com.example.dndn_be.domain.incident.controller;

import com.example.dndn_be.domain.incident.dto.request.IncidentRequest;
import com.example.dndn_be.domain.incident.dto.response.IncidentResponse;
import com.example.dndn_be.domain.incident.service.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/incident")
@RequiredArgsConstructor
public class IncidentController implements IncidentApiDocument {
    private final CreateIncidentService createIncidentService;
    private final QueryIncidentDetailService queryIncidentDetailService;
    private final QueryAllIncidentService queryAllIncidentService;
    private final UpdateIncidentService updateIncidentService;
    private final DeleteIncidentService deleteIncidentService;

    @Override
    @ResponseStatus(HttpStatus.CREATED)
    public void createIncident(@RequestPart(name = "request") @Valid IncidentRequest request,
                               @RequestPart(name = "file") MultipartFile incidentImage) {
        createIncidentService.execute(request, incidentImage);
    }

    @Override
    @ResponseStatus(HttpStatus.OK)
    public IncidentResponse queryIncident(@PathVariable("incident-id") Long incidentId) {
        return queryIncidentDetailService.execute(incidentId);
    }

    @Override
    @ResponseStatus(HttpStatus.OK)
    public List<IncidentResponse> queryAllIncident() {
        return queryAllIncidentService.execute();
    }

    @Override
    @ResponseStatus(HttpStatus.OK)
    public void updateIncident(@PathVariable("incident-id") Long incidentId,
                               @RequestPart(name = "request") @Valid IncidentRequest request,
                               @RequestPart(name = "file") MultipartFile incidentImage) {
        updateIncidentService.execute(incidentId, request,  incidentImage);
    }

    @Override
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteIncident(@PathVariable("incident-id") Long incidentId) {
        deleteIncidentService.execute(incidentId);
    }
}
