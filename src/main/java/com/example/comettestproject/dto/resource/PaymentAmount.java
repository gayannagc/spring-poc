package com.example.comettestproject.dto.resource;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter@Setter
public class PaymentAmount {
    private Money amount;
    private Money dutyFreeAmount;
    private Map<String,Object> extensions;
    private Number percentage;
    private Money taxIncludedAmount;

}
