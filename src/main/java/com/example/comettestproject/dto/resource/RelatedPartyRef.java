package com.example.comettestproject.dto.resource;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class RelatedPartyRef {
    private String referredType;
    private String emailAddress;
    private Map<String,Object> extensions;
    private String firstName;
    private String href;
    private String id;
    private String lastName;
}
