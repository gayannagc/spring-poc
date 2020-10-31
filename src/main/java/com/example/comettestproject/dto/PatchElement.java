package com.example.comettestproject.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class PatchElement {

    @NotNull
    private String op;
    @NotNull
    private String path;
    @NotNull
    private Object value;
}
