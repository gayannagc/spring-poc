package com.example.comettestproject.dto;

public class Error extends Exception {

    private String code;
    private String message;
    private String reason;

    public Error(String code, String message, String reason) {
        this.code = code;
        this.message = message;
        this.reason = reason;
    }
}
