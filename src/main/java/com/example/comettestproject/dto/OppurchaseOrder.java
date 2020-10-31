package com.example.comettestproject.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class OppurchaseOrder {

    @NotNull
    private String msisdn;
    @NotNull
    private String serviceId;
    private String qid;
    private String userName;
    private String channel;

}
