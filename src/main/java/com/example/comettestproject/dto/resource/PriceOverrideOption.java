package com.example.comettestproject.dto.resource;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter@Setter
public class PriceOverrideOption {
    private Map<String ,Object> extensions;
    private String overrideType;
    private PaymentAmount overrideValue;
    private Reason reason;
    private RelatedPartyRef relatedParty;
    private TimePeriod validFor;
}
