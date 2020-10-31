package com.example.comettestproject.dto;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class AttachmentRef {
    @NotNull
    private String id;
    private String href;
    private String name;
    private String url;
}
