package com.example.dndn_be.domain.incident.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class IncidentRequest {

    @NotBlank(message = "사건 제목을 작성해주세요.")
    private String incidentTitle;

    @NotBlank(message = "사건 설명을 입력해주세요")
    private String description;

    @NotNull
    private Double latitude;

    @NotNull
    private Double longitude;
}
