package com.example.comettestproject.dto;


import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class CommonClientResponse {
    HttpStatus httpStatus;
    Object body;
    Exception exception;
}

