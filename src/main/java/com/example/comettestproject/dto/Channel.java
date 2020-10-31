package com.example.comettestproject.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class Channel {

    @JsonProperty("@type")
    private String type;
    private String href;
    private String id;
    @NotNull
    private String name;
    private String role;
}
