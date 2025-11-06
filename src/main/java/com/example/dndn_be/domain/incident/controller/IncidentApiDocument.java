package com.example.dndn_be.domain.incident.controller;

import com.example.dndn_be.domain.incident.dto.request.IncidentRequest;
import com.example.dndn_be.domain.incident.dto.response.IncidentResponse;
import com.example.dndn_be.global.error.ErrorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "incident", description = "든든일지 관련 API")
public interface IncidentApiDocument {

    @Operation(summary = "든든일지 생성", description = "새로운 든든일지를 등록합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "사건 등록 성공"),
            @ApiResponse(responseCode = "400", description = "요청 데이터 오류",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "서버 내부 오류",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = ErrorResponse.class)))
    })

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void createIncident(@ModelAttribute @Valid IncidentRequest request);

    @Operation(summary = "든든일지 상세 조회", description = "특정 ID의 든든일지 정보를 조회합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "조회 성공",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = IncidentResponse.class))),
            @ApiResponse(responseCode = "404", description = "존재하지 않는 사건",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = ErrorResponse.class)))
    })

    @GetMapping("/{incident-id}")
    @ResponseStatus(HttpStatus.OK)
    IncidentResponse queryIncident(@PathVariable("incident-id") Long incidentId);

    @Operation(summary = "모든 든든일지 조회", description = "등록된 모든 든든일지를 조회합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "조회 성공",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = IncidentResponse.class)))
    })

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<IncidentResponse> queryAllIncident();

    @Operation(summary = "든든일지 수정", description = "특정 ID의 든든일지 정보를 수정합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "수정 성공"),
            @ApiResponse(responseCode = "404", description = "존재하지 않는 사건",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = ErrorResponse.class)))
    })

    @PatchMapping("/{incident-id}")
    @ResponseStatus(HttpStatus.OK)
    void updateIncident(@PathVariable("incident-id") Long incidentId,
                        @ModelAttribute @Valid IncidentRequest request);

    @Operation(summary = "든든일지 삭제", description = "특정 ID의 든든일지를 삭제합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "삭제 성공"),
            @ApiResponse(responseCode = "404", description = "존재하지 않는 사건",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = ErrorResponse.class)))
    })

    @DeleteMapping("/{incident-id}")
    @ResponseStatus(HttpStatus.OK)
    void deleteIncident(@PathVariable("incident-id") Long incidentId);
}
