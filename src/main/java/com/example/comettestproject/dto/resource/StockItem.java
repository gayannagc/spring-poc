package com.example.comettestproject.dto.resource;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter@Setter
public class StockItem {
    private Map<String,Object> extensions;
    private Integer stockAvailabilityQuantity;
    private String stockAvailabilityStatus;
}
