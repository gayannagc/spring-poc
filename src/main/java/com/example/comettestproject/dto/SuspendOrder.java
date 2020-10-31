package com.example.comettestproject.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class SuspendOrder {

    @NotNull
    @JsonProperty("modifyOrderItem.product.id")
    private String id;
    @NotNull
    @JsonProperty("modifyReason.name")
    private String name;
    @NotNull
    @JsonProperty("modifyReason.action")
    private String action;
    @NotNull
    @JsonProperty("channel.id")
    private String channelId;
    private String resumptionDate;

}
