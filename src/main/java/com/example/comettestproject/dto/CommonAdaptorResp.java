package com.example.comettestproject.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommonAdaptorResp<T> {

    private Result result;
    private T responseData;
}

