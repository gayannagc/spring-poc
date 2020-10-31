package com.example.comettestproject.dto.resource;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter@Setter
public class PriceAlteration {
    private String type;
    private Integer alterationApplyOrder;
    private String alterationBundleProductOfferingId;
    private String alterationProductOfferingPriceId;
    private String alterationType;
    private Integer applicationDuration;
    private String chargeType;
    private String description;
    private Map<String,Object> extensions;
    private String immediatePromotionId;
    private String name;
    private Price price;
    private String priceType;
    private Integer priority;
    private String promotionActionId;
    private String recurringChargePeriod;
    private String unitOfMeasure;

}
