package com.example.comettestproject.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class PartyInteraction  {

    @JsonProperty("@type")
    private Type type;
    @NotNull
    private List<Channel> channel;
    private ControlFields controlFields;
    private Direction direction;
    @NotNull
    private Map<String, String> extensions;
    private String href;
    private String id;
    @NotNull
    private TimePeriod interactionDate;
    @NotNull
    private List<InteractionItem> interactionItem;
    @NotNull
    private List<RelatedPartyRef> relatedParty;
    private List<AttachmentRef> attachment;
    private String description;
    private String reason;
    private String status;
    private String subStatus;
}
