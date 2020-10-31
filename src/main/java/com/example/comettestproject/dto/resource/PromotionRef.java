package com.example.comettestproject.dto.resource;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class PromotionRef {
    private String description;
    private String href;
    private String id;
    private String name;
    private TimePeriod validFor;
}
