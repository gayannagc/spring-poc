package com.example.comettestproject.dto.resource;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@ToString
public class ProductOrder {
    private String type;
    private BillingAccountRef billingAccount;
    private String category;
    private List<ChannelRef> channel;
    private String completionDate;
    private String description;
    private String expectedCompletionDate;
    private  Map<String,Object> extensions;
    private String externalId;
    private List<ExternalIdentifier> externalIdentifier;
    private String href;
    private String id;
    private List<ImmediatePromotion> immediatePromotion;
    private boolean isCustomerVisible;
    private String lastUpdate;
    private List<Note> note;
    private String notificationContact;
    private String orderDate;
    @NotNull
    private List<OrderItemInfo> orderItem;
    private String orderPriceDate;
    private List<OrderRelationship> orderRelationship;
    private List<OrderPrice> orderTotalPrice;
    private List<PaymentRef> payment;
    private String priority;
    private List<RelatedPartyRef> relatedParty;
    private String requestedCompletionDate;
    private String requestedStartDate;
    private String state;
    private Validation validation;

}
