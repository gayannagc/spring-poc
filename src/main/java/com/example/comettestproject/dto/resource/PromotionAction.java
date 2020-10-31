package com.example.comettestproject.dto.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Map;

@Getter@Setter
public class PromotionAction {
    @NotNull
    private String actionType;
    private Integer actionValue;
    private String description;
    private DurationPolicy durationPolicy;
    private Map<String,Object> extensions;
    private String id;
    private String name;
    private ProductOfferingPriceRef promotionPriceAlteration;
    private TimePeriod validFor;
}
