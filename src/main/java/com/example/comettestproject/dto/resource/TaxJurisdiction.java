package com.example.comettestproject.dto.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Map;

@Getter
@Setter
public class TaxJurisdiction {
    private Map<String,Object> extension;
    private String id;
    @NotNull
    private String level;
    @NotNull
    private String name;
}
