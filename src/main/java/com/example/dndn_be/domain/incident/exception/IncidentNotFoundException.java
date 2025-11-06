package com.example.dndn_be.domain.incident.exception;

import com.example.dndn_be.global.error.exception.DndnException;
import com.example.dndn_be.global.error.exception.ErrorCode;

public class IncidentNotFoundException extends DndnException {
    public static final DndnException EXCEPTION = new IncidentNotFoundException();

    private IncidentNotFoundException() {
        super(ErrorCode.INCIDENT_NOT_FOUND);
    }
}
