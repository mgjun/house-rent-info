package com.example.houserentinfo.util;

import com.example.houserentinfo.dto.BaseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.io.File;
import java.util.List;

@ControllerAdvice(annotations = {RestController.class,ControllerAdvice.class})
@Slf4j
public class HouseRentResponseBodyAdvice implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        log.debug("HouseRentResponseBodyAdvice==>supports:{}", converterType);
        log.debug("HouseRentResponseBodyAdvice==>supports:{}", returnType.getClass());
        log.debug("HouseRentResponseBodyAdvice==>supports:{}",
                MappingJackson2HttpMessageConverter.class.isAssignableFrom(converterType));
        return MappingJackson2HttpMessageConverter.class.isAssignableFrom(converterType);
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        if (ignoreToConvert(body)) {
            return body;
        }
        log.debug("HouseRentResponseBodyAdvice==>beforeBodyWrite:{} , {}", returnType, body);
        if(body instanceof List) {
            return RestResponse.builder()
                    .success(StatusCode.SUCCESS)
                    .dataList((List) body)
                    .build();
        }

        return RestResponse.builder()
                .success(StatusCode.SUCCESS)
                .data(body)
                .build();
    }

    private Boolean ignoreToConvert(Object body) {
        return body == null
                || body instanceof File
                || body instanceof RestResponse;
    }
}
