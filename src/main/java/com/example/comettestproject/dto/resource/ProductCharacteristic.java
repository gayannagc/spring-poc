package com.example.comettestproject.dto.resource;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter@Setter
public class ProductCharacteristic {
    private String type;
    private Map<String,Object> extensions;
    private List<Metadata> metadata;
    private String name;
    private String value;
}
