package com.example.comettestproject.dto.resource;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class Validation {
    private List<ConfigurationChange> configurationChange;
    private Map<String,Object> extensions;
    private String status;
    private List<ValidationMessage> validationMessage;
}
