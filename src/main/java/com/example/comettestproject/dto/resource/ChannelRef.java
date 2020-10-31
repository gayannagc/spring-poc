package com.example.comettestproject.dto.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter@Setter
public class ChannelRef {
    private String type;
    private String href;
    @NotNull
    private String id;
    private String name;
    private String role;
}
