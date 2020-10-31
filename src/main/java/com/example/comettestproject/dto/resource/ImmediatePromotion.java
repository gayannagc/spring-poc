package com.example.comettestproject.dto.resource;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter@Setter
public class ImmediatePromotion {
    private List<BenefitItem> benefitItem;
    private Map<String,Object> extensions;
    private String id;
    private ProductPromotionRef productPromotion;
    private PromotionRef promotion;
    private String status;
    private List<TriggerItem> triggerItem;
}
