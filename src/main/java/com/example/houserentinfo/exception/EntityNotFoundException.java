package com.example.houserentinfo.exception;

import com.example.houserentinfo.util.StatusCode;

public class EntityNotFoundException extends BaseException {
    public EntityNotFoundException(StatusCode code, String message) {
        super(code, message);
    }
}
