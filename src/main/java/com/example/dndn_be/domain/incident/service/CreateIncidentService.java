package com.example.dndn_be.domain.incident.service;

import com.example.dndn_be.domain.incident.domain.Incident;
import com.example.dndn_be.domain.incident.domain.repository.IncidentRepository;
import com.example.dndn_be.domain.incident.dto.request.IncidentRequest;
import com.example.dndn_be.domain.user.domain.User;
import com.example.dndn_be.domain.user.facade.UserFacade;
import com.example.dndn_be.infrastructure.s3.service.S3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class CreateIncidentService {
    private final UserFacade userFacade;
    private final IncidentRepository incidentRepository;
    private final S3Service s3Service;

    @Transactional
    public void execute(IncidentRequest request, MultipartFile incidentImage) {
        User user = userFacade.getCurrentUser();

        String incidentUrl = s3Service.upload(incidentImage);

        incidentRepository.save(Incident.builder()
                .incidentTitle(request.getIncidentTitle())
                .description(request.getDescription())
                .latitude(request.getLatitude())
                .longitude(request.getLongitude())
                .incidentImage(incidentUrl)
                .user(user)
                .build());
    }
}
