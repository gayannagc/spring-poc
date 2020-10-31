package com.example.comettestproject.dto.resource;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ConfigurationChangeParameter {
    private String name;
    private List<String> value;
}
