package com.example.dndn_be.domain.incident.service;

import com.example.dndn_be.domain.incident.domain.Incident;
import com.example.dndn_be.domain.incident.domain.repository.IncidentRepository;
import com.example.dndn_be.domain.incident.dto.response.IncidentResponse;
import com.example.dndn_be.domain.incident.exception.IncidentNotFoundException;
import com.example.dndn_be.domain.user.domain.User;
import com.example.dndn_be.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class QueryIncidentDetailService {
    private final IncidentRepository incidentRepository;
    private final UserFacade userFacade;

    @Transactional(readOnly = true)
    public IncidentResponse execute(Long incidentId) {
        User user = userFacade.getCurrentUser();

        Incident incident = incidentRepository.findById(incidentId)
                .orElseThrow(() -> IncidentNotFoundException.EXCEPTION);

        return IncidentResponse.builder()
                .id(incident.getId())
                .incidentTitle(incident.getIncidentTitle())
                .description(incident.getDescription())
                .latitude(incident.getLatitude())
                .longitude(incident.getLongitude())
                .incidentImage(incident.getIncidentImage())
                .build();
    }
}
