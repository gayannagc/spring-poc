package com.example.comettestproject.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Map;


@Getter
@Setter
public class TimePeriod {

    @NotNull
    private String endDateTime;
    private Map<String, Object> extension;
    @NotNull
    private String startDateTime;
}

