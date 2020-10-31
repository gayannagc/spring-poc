package com.example.comettestproject.dto.resource;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter@Setter
public class DurationPolicy {
    private Quantity duration;
    private TimePeriod effectiveFor;
    private String endDatePolicy;
    private Map<String,Object> extensions;
    private String startDatePolicy;
}
