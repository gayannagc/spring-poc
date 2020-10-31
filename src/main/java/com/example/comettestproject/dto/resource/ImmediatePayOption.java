package com.example.comettestproject.dto.resource;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter@Setter
public class ImmediatePayOption {
    private Map<String,Object> extensions;
    private Money minPayAmount;
    private Money payAmount;
    private boolean payImmediately;
    private String payOption;

}
