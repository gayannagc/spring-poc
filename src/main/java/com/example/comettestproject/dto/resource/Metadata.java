package com.example.comettestproject.dto.resource;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter@Setter
public class Metadata {
    private Map<String,Object> extensions;
    private String metadataType;
    private String name;
    private String value;
}
