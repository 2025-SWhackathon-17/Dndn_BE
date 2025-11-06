package com.example.dndn_be.domain.auth.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class LoginRequest {

    @NotBlank(message = "계정ID를 입력해주세요.")
    private String accountId;

    @NotBlank(message = "비밀번호를 입력해주세요.")
    private String password;
}
