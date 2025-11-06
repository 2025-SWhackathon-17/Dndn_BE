package com.example.dndn_be.domain.incident.dto.response;

import com.example.dndn_be.domain.incident.domain.Incident;
import lombok.Builder;

@Builder
public record IncidentResponse(
        Long id,
        String incidentTitle,
        String description,
        Double latitude,
        Double longitude,
        String incidentImage
) {
    public static IncidentResponse from(Incident incident) {
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
