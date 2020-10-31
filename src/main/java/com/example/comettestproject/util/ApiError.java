package com.example.comettestproject.util;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiError extends ApiException {

    private  String code;
    private String message;
    private String reason;

    public ApiError(String code, String message, String reason) {
        this.code = code;
        this.message = message;
        this.reason = reason;
    }

    public ApiError(String code, String message) {
        this.code = code;
        this.message = message;
    }
    public ApiError( String message) {
        this.message = message;

    }

}

