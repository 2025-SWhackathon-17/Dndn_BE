package com.example.dndn_be.domain.incident.dto.response;

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
}
