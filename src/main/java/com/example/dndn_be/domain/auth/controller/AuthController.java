package com.example.dndn_be.domain.auth.controller;

import com.example.dndn_be.domain.auth.dto.request.LoginRequest;
import com.example.dndn_be.domain.auth.dto.request.SignupRequest;
import com.example.dndn_be.domain.auth.dto.response.TokenResponse;
import com.example.dndn_be.domain.auth.service.LoginService;
import com.example.dndn_be.domain.auth.service.SignupService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final SignupService signupService;
    private final LoginService loginService;

    @PostMapping("/sign-up")
    @ResponseStatus(HttpStatus.CREATED)
    public void signup(@RequestBody @Valid SignupRequest request) {
        signupService.execute(request);
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public TokenResponse login(@RequestBody @Valid LoginRequest request) {
        return loginService.execute(request);
    }
}
