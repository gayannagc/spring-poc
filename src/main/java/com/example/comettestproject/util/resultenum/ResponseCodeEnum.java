package com.example.comettestproject.util.resultenum;

public enum ResponseCodeEnum {
    SUCCESSFUL("00","SUCCESSFUL"),

    //Internal Exceptions
    INTERNAL_SERVER_ERROR("99", "INTERNAL SERVER ERROR"),
    EXCEPTION_HTTP_CLIENT("98", "EXCEPTION IN HTTP CLIENT"),
    EXCEPTION_DB_LAYER("97","EXCEPTION IN DB LAYER"),
    EXCEPTION_SERVICE_LAYER("96", "EXCEPTION IN UMS SERVICE LAYER"),
    EXCEPTION_ADVISER_CONTROLLER("95", "EXCEPTION IN LOGGING ADVISER - CONTROLLER"),
    EXCEPTION_ADVISER_SERVICE_LAYER("94", "EXCEPTION IN LOGGING ADVISER - SERVICE LAYER"),
    EXCEPTION_ADVISER_ADAPTER_INTEGRATION_LAYER("93", "EXCEPTION IN LOGGING ADVISER - ADAPTER INTEGRATION"),
    EXCEPTION_ADVISER_REPOSITORY_LAYER("92", "EXCEPTION IN LOGGING ADVISER - ADAPTER INTEGRATION"),
    INVALID_TOKEN("21", "INVALID TOKEN"),
    INVALID_INPUT("20", "INVALID INPUT"),

    //not found
    OPERATION_FAILED("31","DATABASE OPERATION FAILED"),
    NOT_FOUND("30","NOT FOUND"),


    UPDATE_EXCEPTION("50","UPDATE OPERATION FAILED"),
    CREATE_EXCEPTION("51","CREATE OPERATION FAILED" ),
    DELETE_EXCEPTION("52", "DELETE OPERATION FAILED");

    private String code;
    private String description;
    ResponseCodeEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }
    public String code() {
        return code;
    }
    public String description() { return description; }
}
