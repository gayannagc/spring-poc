package com.example.comettestproject.util.constants;

import org.springframework.stereotype.Component;

@Component
public class LoggingAdviceConstants {


    private LoggingAdviceConstants(){}

    public static final String API_NAME = "API-Name";
    public static final String CLASS_NAME = "Class-Name";
    public static final String METHOD_NAME = "Method-Name";
    public static final String PACKAGE_ROOT = "com.adl.et.telco.comet.bssadaptor";
    public static final String REQUEST_INITIATED = "REQUEST_INITIATED | REQUEST_METHOD : {} | REQUEST_URI : {}";
    public static final String FULL_REQUEST = "FULL_REQUEST | CONTROLLER_REQUEST : {}";
    public static final String FULL_RESPONSE = "FULL_RESPONSE | CONTROLLER_RESPONSE : {}";
    public static final String REQUEST_TERMINATED = "REQUEST_TERMINATED | RESPONSE_MESSAGE : {} | RESPONSE_CODE : {} | HTTP_STATUS : {} | RESPONSE_TIME : {} ms";
    public static final String EXCEPTION_REQUEST_TERMINATED = "EXCEPTION | REQUEST_TERMINATED | ERROR_MESSAGE : {} | ERROR_REASON : {} | ERROR_CODE : {} | HTTP_STATUS : {} | ERROR_STACKTRACE : {} | RESPONSE_TIME : {} ms";
    public static final String EXCEPTION_STACKTRACE = "EXCEPTION | STACKTRACE : {}";
    public static final String SERVICE_INITIATED = "SERVICE_INITIATED | REQUEST_ARGS : {}";
    public static final String SERVICE_TERMINATED = "SERVICE_TERMINATED | RESPONSE_BODY : {} | RESPONSE_TIME : {} ms";
    public static final String EXCEPTION_SERVICE_TERMINATED = "EXCEPTION | SERVICE_TERMINATED | ERROR_MESSAGE : {} | ERROR_REASON : {} | ERROR_CODE : {} | HTTP_STATUS : {} | RESPONSE_TIME : {} ms";
    public static final String HTTP_CLIENT_INITIATED = "HTTP_CLIENT_INITIATED | REQUEST_ARGS : {}";
    public static final String HTTP_CLIENT_TERMINATED = "HTTP_CLIENT_TERMINATED | RESPONSE_BODY : {} | RESPONSE_TIME : {} ms";
    public static final String EXCEPTION_HTTP_CLIENT_TERMINATED = "EXCEPTION | HTTP_CLIENT_TERMINATED | ERROR_MESSAGE : {} | ERROR_REASON : {} | ERROR_CODE : {} | HTTP_STATUS : {} | RESPONSE_TIME : {} ms";
    public static final String EXCEPTION_REPOSITORY_TERMINATED = "EXCEPTION | HTTP_REPOSITORY_TERMINATED | ERROR_MESSAGE : {} | ERROR_REASON : {} | ERROR_CODE : {} | HTTP_STATUS : {} | RESPONSE_TIME : {} ms";
    public static final String REPOSITORY_TERMINATED = "REPOSITORY_TERMINATED | RESPONSE_TIME : {} ms";


}
