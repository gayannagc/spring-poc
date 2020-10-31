package com.example.comettestproject.dto.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class AppliedTax {
    private List<Characteristic> characteristic;
    private Map<String,Object> extension;
    private TimePeriod periodCoverage;
    @NotNull
    private Money taxAmount;
    @NotNull
    private TaxDefinition taxDefinition;
    @NotNull
    private Money taxableAmount;
}
