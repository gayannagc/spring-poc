package com.example.comettestproject.dto.resource;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter@Setter
public class OrderItem {
    private String type;
    private String action;
    private AppointmentRef appointment;
    private BillingAccountRef billingAccount;
    private List<ProductCharacteristic> characteristic;
    private String completionDate;
    private String creationDate;
    private String expectedCompletionDate;
    private Map<String,Object> extensions;
    private String externalId;
    private List<ExternalIdentifier> externalIdentifier;
    private String id;
    private List<OrderPrice> itemPrice;
    private List<OrderTerm> itemTerm;
    private List<OrderPrice> itemTotalPrice;
    private List<Metadata> metadata;
    private List<ModifyReason> modifyReason;
    private List<Note> note;
    private List<OrderItem> orderItem;
    private List<OrderItemRelationship> orderItemRelationship;
    private List<PaymentRef> payment;
    private Product product;
    private ProductOfferingRef productOffering;
    private ProductOfferingGroupOption productOfferingGroupOption;
    private Integer quantity;
    private boolean readOnly;
    private List<RelatedImmediatePromotion> relatedImmediatePromotion;
    private String requestedCompletionDate;
    private String requestedStartDate;
    private String retroactiveChangeDate;
    private String state;
    private List<StockItem> stock;
    private List<ProductStockReservationRef> stockReservation;



 }
