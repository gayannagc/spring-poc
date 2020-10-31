package com.example.comettestproject.dto.resource;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ConfigurationChange {
    private String id;
    private List<ConfigurationChangeParameter> parameter;
    private String path;
    private String severity;
    private boolean skipRevalidation;
    private String text;
    private String type;

}
