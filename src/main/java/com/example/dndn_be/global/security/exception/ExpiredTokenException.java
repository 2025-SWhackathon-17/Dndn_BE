package com.example.dndn_be.global.security.exception;

import com.example.dndn_be.global.error.exception.DndnException;
import com.example.dndn_be.global.error.exception.ErrorCode;

public class ExpiredTokenException extends DndnException {
    public static final DndnException EXCEPTION = new ExpiredTokenException();

    public ExpiredTokenException() {
        super(ErrorCode.EXPIRED_TOKEN);
    }
}
