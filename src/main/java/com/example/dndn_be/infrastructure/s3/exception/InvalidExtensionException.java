package com.example.dndn_be.infrastructure.s3.exception;

import com.example.dndn_be.global.error.exception.DndnException;
import com.example.dndn_be.global.error.exception.ErrorCode;

public class InvalidExtensionException extends DndnException {
    public static final DndnException EXCEPTION = new InvalidExtensionException();

    private InvalidExtensionException() {
        super(ErrorCode.INVALID_EXTENSION);
    }
}
