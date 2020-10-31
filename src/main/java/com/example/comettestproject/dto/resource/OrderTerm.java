package com.example.comettestproject.dto.resource;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class OrderTerm {
    private String type;
    private List<Attachment> attachment;
    private String description;
    private Quantity duration;
    private Map<String,Object> extensions;
    private String freezeDate;
}
