package com.example.comettestproject.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ControlFields {
    @NotNull
    private String createdBy;
    @NotNull
    private String createdOn;
    private String lastModifiedBy;
    private String lastModifiedOn;
    private String moedlVersion;
}
