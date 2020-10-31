package com.example.comettestproject.dto.resource;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter
@ToString
public class ProductOrderRef {
    private String href;
    private String id;
    private String orderItemId;
    private Validation validation;
}
