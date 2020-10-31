package com.example.comettestproject.dto.resource;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class TimePeriod {
    private String endDateTime;
    private Map<String,Object> extensions;
    private String startDateTime;
}
