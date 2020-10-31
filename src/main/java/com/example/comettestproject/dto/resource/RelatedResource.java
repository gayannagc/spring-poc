package com.example.comettestproject.dto.resource;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RelatedResource {
    private List<ContainedResource> containedResource;
    private String id;
    private String type;
    private List<Variable> variable;
}
