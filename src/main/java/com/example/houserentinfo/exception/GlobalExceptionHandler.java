package com.example.houserentinfo.exception;

import com.example.houserentinfo.util.HouseRentHttpStatus;
import com.example.houserentinfo.util.RestResponse;
import com.example.houserentinfo.util.StatusCode;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice(annotations = RestController.class)
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public RestResponse mapUnHandledException(HttpServletRequest request, RuntimeException ex) {
        log.error("unknown error", ex);
        return RestResponse.builder()
                .errorCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
                .success(StatusCode.ERROR)
                .build();
    }


    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseBody
    public RestResponse mapEntityNotFoundException(HttpServletRequest request, EntityNotFoundException ex) {
        log.error("unknown error", ex);
        return RestResponse.builder()
                           .errorCode(HttpStatus.BAD_REQUEST.value())
                           .message(ex.getErrorMessage())
                           .success(StatusCode.ENTITY_NOT_FOUND)
                           .build();
    }


    @ExceptionHandler(ShiroException.class)
    @ResponseBody
    public RestResponse mapIncorrectCredentialException(HttpServletRequest request, Exception ex) {
        if (ex instanceof UnknownAccountException || ex instanceof IncorrectCredentialsException) {
            return RestResponse.builder()
                    .errorCode(HouseRentHttpStatus.UNAUTHORIZED_USER.value())
                    .message(HouseRentHttpStatus.UNAUTHORIZED_USER.getReasonPhrase())
                    .success(StatusCode.ERROR)
                    .build();
        }
        if (ex instanceof DisabledAccountException) {
            return RestResponse.builder()
                    .errorCode(HouseRentHttpStatus.DISABLED_USER.value())
                    .message(HouseRentHttpStatus.DISABLED_USER.getReasonPhrase())
                    .success(StatusCode.ERROR)
                    .build();
        }
        return RestResponse.builder()
                .errorCode(HouseRentHttpStatus.UNKNOWN_LOGIN_FAILED.value())
                .message(HouseRentHttpStatus.UNKNOWN_LOGIN_FAILED.getReasonPhrase())
                .success(StatusCode.ERROR)
                .build();

    }
}
