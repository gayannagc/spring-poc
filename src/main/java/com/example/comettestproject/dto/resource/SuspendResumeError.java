package com.example.comettestproject.dto.resource;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SuspendResumeError {

    private String type;
    private String code;
    private String reason;
    private String status;
    private String referenceError;
    private String traceId;

}

