package com.example.comettestproject.dto.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Map;

@Getter
@Setter
public class TaxDefinition {
    private String category;
    @NotNull
    private String exemptionType;
    private Map<String,Object> extension;
    @NotNull
    private boolean isExemption;
    private String name;
    @NotNull
    private TaxJurisdiction taxJurisdiction;
    @NotNull
    private Number taxRate;
    @NotNull
    private String taxType;
    @NotNull
    private TimePeriod validFor;
}
