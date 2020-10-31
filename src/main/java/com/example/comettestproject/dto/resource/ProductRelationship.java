package com.example.comettestproject.dto.resource;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter@Setter
public class ProductRelationship {
    private Map<String,Object> extensions;
    private Product product;
    private String subType;
    private String type;
}
