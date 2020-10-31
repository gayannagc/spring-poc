package com.example.comettestproject.dto.resource;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class OrderPrice {
    private String type;
    private BillingAccountRef billingAccount;
    private String description;
    private Map<String,Object> extensions;
    private Price finalPrice;
    private String id;
    private ImmediatePayOption immediatePayOption;
    private InstallmentOptions installmentOption;
    private String name;
    private OrderPriceRelationship orderPriceRelationship;
    private Price price;
    private List<PriceAlteration> priceAlteration;
    private PriceOverrideOption priceOverrideOption;
    private String priceType;
    private String recurringChargePeriod;
    private Integer recurringChargePeriodLength;
    private String role;
    private Price standalonePrice;
    private String taxIncluded;
    private String unitOfMeasure;
}
