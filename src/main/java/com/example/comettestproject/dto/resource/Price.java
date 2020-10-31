package com.example.comettestproject.dto.resource;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class Price {
    private List<AppliedTax> appliedTax;
    private Money dutyFreeAmount;
    private Map<String,Object> extensions;
    private List<PriceParam> impactingPriceParameter;
    private Float percentage;
    private Money priceOverride;
    private String priceRecordId;
    private Money priceReduction;
    private Money taxAmount;
    private Money taxIncludedAmount;
    private Float taxRate;
}
