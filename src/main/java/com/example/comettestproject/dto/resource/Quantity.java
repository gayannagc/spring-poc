package com.example.comettestproject.dto.resource;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter@Setter
public class Quantity {
    private Number amount;
    private Map<String,Object> extensions;
    private String units;
}
