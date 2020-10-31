package com.example.comettestproject.dto.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter@Setter
public class ProductOfferingRef {
    private String referredType;
    private List<Attachment> attachment;
    private DurationPolicy durationPolicy;
    private String href;
    @NotNull
    private String id;
    private String name;
}
