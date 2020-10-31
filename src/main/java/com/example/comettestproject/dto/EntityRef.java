package com.example.comettestproject.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class EntityRef {

    @NotNull
    @JsonProperty("@referedtype")
    private String referedtype;
    private String href;
    @NotNull
    private String id;
    private String name;
    private String role;
}
