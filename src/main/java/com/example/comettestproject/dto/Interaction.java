package com.example.comettestproject.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@ToString
public class Interaction {
    private String interactionId;
    private String msisdn;
    private Type type;
    @NotNull(message = "required field channel missing")
    private String channel;
    private String createdBy;
    private String createdOn;
    private Direction direction;
    @NotNull(message = "required field title missing")
    private String title;
    private String otherChannelId;
    @NotNull(message = "required field periodEnd missing")
    private String periodEnd;
    @NotNull(message = "required field periodStart missing")
    private String periodStart;
    @Valid
    private List<WidgetInteractionItem> interactionItems;
    private boolean sendSurvey;
    private List<RelatedPartyRef> relatedParty;



}
