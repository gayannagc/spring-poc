package com.example.comettestproject.dto.resource;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter@Setter
public class TriggerItem {
    private Map<String,Object> extensions;
    private String href;
    private String id;
    private String itemStatus;
    private String itemType;
    private String pathToRoot;
    private String promotionCriteriaGroupId;
}
