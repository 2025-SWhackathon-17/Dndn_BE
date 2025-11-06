package com.example.dndn_be.domain.incident.service;

import com.example.dndn_be.domain.incident.domain.repository.IncidentRepository;
import com.example.dndn_be.domain.incident.dto.response.IncidentResponse;
import com.example.dndn_be.domain.user.domain.User;
import com.example.dndn_be.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QueryAllIncidentService {
    private final IncidentRepository incidentRepository;
    private final UserFacade userFacade;

    @Transactional(readOnly = true)
    public List<IncidentResponse> execute() {
        User user = userFacade.getCurrentUser();

        return incidentRepository.findAll()
                .stream()
                .map(IncidentResponse::from)
                .toList();
    }
}
