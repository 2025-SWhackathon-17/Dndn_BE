package com.example.dndn_be.domain.user.exception;

import com.example.dndn_be.global.error.exception.DndnException;
import com.example.dndn_be.global.error.exception.ErrorCode;

public class ExistUserException extends DndnException {
    public static final DndnException EXCEPTION = new ExistUserException();

    private ExistUserException() {
        super(ErrorCode.EXIST_USER);
    }
}
