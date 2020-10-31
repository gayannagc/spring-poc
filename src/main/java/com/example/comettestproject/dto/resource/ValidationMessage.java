package com.example.comettestproject.dto.resource;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ValidationMessage {
    private String id;
    private List<ValidationMessageParameter> parameter;
    private String path;
    private List<RelatedResource> resource;
    private String severity;
    private String subtype;
    private String text;
    private String type;
}
