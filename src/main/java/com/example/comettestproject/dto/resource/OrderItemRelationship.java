package com.example.comettestproject.dto.resource;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter@Setter
public class OrderItemRelationship {
    private Map<String,Object> extensions;
    private String externalId;
    private String id;
    private String type;
}
