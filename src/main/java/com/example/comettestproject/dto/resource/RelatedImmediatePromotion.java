package com.example.comettestproject.dto.resource;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter@Setter
public class RelatedImmediatePromotion {
    private Map<String,Object> extensions;
    private String id;
    private String itemQualificationType;
    private String itemStatus;
}
