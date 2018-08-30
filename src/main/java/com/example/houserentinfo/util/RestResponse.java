package com.example.houserentinfo.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RestResponse<T> {

    private StatusCode success;

    private Integer errorCode;

    private String message;

    private T data;

    private List<T> dataList;


}
