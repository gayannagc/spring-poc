package com.example.comettestproject.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

@Data
@JacksonXmlRootElement(localName = "ns1:CommonResponse")
public class CommonResponse {
    @JacksonXmlProperty(localName = "ns1:ResponseCode")
    private String responseCode;
}
