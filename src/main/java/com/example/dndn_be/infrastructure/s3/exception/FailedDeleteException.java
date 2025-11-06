package com.example.dndn_be.infrastructure.s3.exception;


import com.example.dndn_be.global.error.exception.DndnException;
import com.example.dndn_be.global.error.exception.ErrorCode;

public class FailedDeleteException extends DndnException {
    public static final DndnException EXCEPTION = new FailedDeleteException();

    private FailedDeleteException() {
        super(ErrorCode.FAILED_DELETE);
    }
}
