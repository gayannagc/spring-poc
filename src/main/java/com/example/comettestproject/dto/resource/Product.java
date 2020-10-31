package com.example.comettestproject.dto.resource;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter@Setter
public class Product {
    private String activationDate;
    private Integer alternateId;
    private List<ProductCharacteristic> characteristic;
    private Map<String,Object> extensions;
    private String href;
    private String id;
    private List<Metadata> metadata;
    private String name;
    private List<PlaceRef> place;
    private String primaryProductId;
    private ProductOrderRef productOrder;
    private List<ProductRelationship> productRelationship;
    private ProductSpecificationRef productSpecification;
    private String referenceId;
    private List<RelatedPartyRef> relatedParty;
    private String status;
    private String terminationDate;
    private String version;
}
