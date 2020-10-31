package com.example.comettestproject.dto.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Map;

@Getter@Setter
public class OrderPriceRelationship {
    private Map<String,Object> extensions;
    @NotNull
    private String id;
    @NotNull
    private String type;
}
