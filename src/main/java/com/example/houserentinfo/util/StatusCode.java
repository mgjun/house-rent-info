package com.example.houserentinfo.util;

public enum StatusCode {

    SUCCESS("SUCCESS"),ERROR("ERROR"),ENTITY_NOT_FOUND("ENTITY_NOT_FOUND");

    private final String status;

    StatusCode(String status) {
        this.status = status;
    }
}
