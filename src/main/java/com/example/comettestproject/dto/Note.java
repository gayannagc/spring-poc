package com.example.comettestproject.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Map;

@Getter
@Setter
public class Note {
    private String author;
    private String date;
    private Map<String, Object> extensions;
    private String id;
    @NotNull
    private String text;

}
