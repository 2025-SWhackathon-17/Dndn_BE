package com.example.dndn_be.domain.user.exception;


import com.example.dndn_be.global.error.exception.DndnException;
import com.example.dndn_be.global.error.exception.ErrorCode;

public class UserNotFoundException extends DndnException {

    public static final DndnException EXCEPTION = new UserNotFoundException();

    private UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }
}
