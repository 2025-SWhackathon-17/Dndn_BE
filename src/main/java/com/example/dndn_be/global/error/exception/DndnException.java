package com.example.dndn_be.global.error.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class DndnException extends RuntimeException {
    private final ErrorCode errorCode;
}
