package com.example.comettestproject.dto.resource;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class PlaceRef {
    private String referredType;
    private String href;
    private String id;
    private String name;
    private String role;
}
