package com.example.comettestproject.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@JacksonXmlRootElement(localName = "ns0:Header")
public class SoapResponseHeader {
    @JacksonXmlProperty(localName = "ns1:CommonResponse")
    private CommonResponse commonResponse;
}
