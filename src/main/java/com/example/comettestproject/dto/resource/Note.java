package com.example.comettestproject.dto.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Map;

@Getter@Setter
public class Note {
    private String date;
    private Map<String,Object> extensions;
    private String id;
    private String noteType;
    @NotNull
    private String text;
}
