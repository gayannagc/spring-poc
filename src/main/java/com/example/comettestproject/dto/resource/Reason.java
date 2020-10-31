package com.example.comettestproject.dto.resource;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter@Setter
public class Reason {
    private Map<String,Object> extensions;
    private String id;
    private String name;
    private String reasonText;
}
