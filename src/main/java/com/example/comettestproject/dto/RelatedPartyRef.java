package com.example.comettestproject.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RelatedPartyRef {
    @JsonProperty("@reerredtype")
    private String referredtype;
    private String href;
    private String id;
    private String name;
    private String role;
    private TimePeriod validFor;
}
