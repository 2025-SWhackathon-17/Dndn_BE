package com.example.dndn_be.domain.auth.service;

import com.example.dndn_be.domain.auth.dto.request.SignupRequest;
import com.example.dndn_be.domain.user.domain.User;
import com.example.dndn_be.domain.user.domain.repository.UserRepository;
import com.example.dndn_be.domain.user.exception.ExistUserException;
import com.example.dndn_be.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SignupService {
    private final UserRepository userRepository;
    private final UserFacade userFacade;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void execute(SignupRequest request) {
        User user = userFacade.getCurrentUser();

        if (userRepository.findByAccountId(request.getAccountId()).isPresent()) {
            throw ExistUserException.EXCEPTION;
        }

        userRepository.save(User.builder()
                .accountId(request.getAccountId())
                .password(passwordEncoder.encode(request.getPassword()))
                .userName(request.getUserName())
                .build());
    }
}
