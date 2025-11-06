package com.example.dndn_be.domain.auth.service;

import com.example.dndn_be.domain.auth.dto.request.LoginRequest;
import com.example.dndn_be.domain.auth.dto.response.TokenResponse;
import com.example.dndn_be.domain.user.domain.User;
import com.example.dndn_be.domain.user.domain.repository.UserRepository;
import com.example.dndn_be.domain.user.exception.PasswordMismatchException;
import com.example.dndn_be.domain.user.exception.UserNotFoundException;
import com.example.dndn_be.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    @Transactional
    public TokenResponse execute(LoginRequest request) {
        User user = userRepository.findByAccountId(request.getAccountId())
                .orElseThrow(()-> UserNotFoundException.EXCEPTION);


        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw PasswordMismatchException.EXCEPTION;
        }

        return jwtTokenProvider.receiveToken(request.getAccountId());
    }
}
