package com.example.houserentinfo.exception;

import com.example.houserentinfo.util.StatusCode;
import lombok.Getter;

@Getter
public class BaseException extends RuntimeException{

    private StatusCode code;
    private String errorMessage;

    public BaseException(StatusCode code, String errorMessage) {
        this.code = code;
        this.errorMessage = errorMessage;
    }


}
