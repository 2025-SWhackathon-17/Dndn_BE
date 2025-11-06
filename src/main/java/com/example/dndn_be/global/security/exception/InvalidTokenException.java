package com.example.dndn_be.global.security.exception;

import com.example.dndn_be.global.error.exception.DndnException;
import com.example.dndn_be.global.error.exception.ErrorCode;

public class InvalidTokenException extends DndnException {
    public static final DndnException EXCEPTION = new InvalidTokenException();

    public InvalidTokenException() {
        super(ErrorCode.INVALID_TOKEN);
    }
}
