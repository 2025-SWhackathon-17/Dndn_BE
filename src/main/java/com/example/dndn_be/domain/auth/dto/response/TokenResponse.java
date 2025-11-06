package com.example.dndn_be.domain.auth.dto.response;

import lombok.Builder;

@Builder
public record TokenResponse(
        String accessToken,
        String refreshToken
) {
}
