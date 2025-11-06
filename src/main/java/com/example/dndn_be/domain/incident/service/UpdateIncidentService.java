package com.example.dndn_be.domain.incident.service;

import com.example.dndn_be.domain.incident.domain.Incident;
import com.example.dndn_be.domain.incident.domain.repository.IncidentRepository;
import com.example.dndn_be.domain.incident.dto.request.IncidentRequest;
import com.example.dndn_be.domain.incident.exception.IncidentNotFoundException;
import com.example.dndn_be.domain.user.domain.User;
import com.example.dndn_be.domain.user.facade.UserFacade;
import com.example.dndn_be.infrastructure.s3.service.S3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UpdateIncidentService {
    private final IncidentRepository incidentRepository;
    private final UserFacade userFacade;
    private final S3Service s3Service;

    @Transactional
    public void execute(Long incidentId, IncidentRequest request) {
        User user = userFacade.getCurrentUser();

        Incident incident = incidentRepository.findById(incidentId)
                .orElseThrow(() -> IncidentNotFoundException.EXCEPTION);

        String incidentImage = s3Service.upload(request.getIncidentImage());

        incident.update(request.getIncidentTitle(), request.getDescription(),
                request.getLatitude(), request.getLongitude(), incidentImage);
    }
}
