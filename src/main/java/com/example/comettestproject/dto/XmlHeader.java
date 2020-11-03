package com.example.comettestproject.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

@Data
@JacksonXmlRootElement(localName = "req:Header")
public class XmlHeader {

    @JacksonXmlProperty(localName = "req:ApplicationID")
    private final String field1 = "svcBilSMSSurveyV1.0";
    @JacksonXmlProperty(localName = "req:EndSystem")
    private final String field2 = "JMSInstance01.XL.BIL.SMSSURVEY.V1_0.REQ";
}
