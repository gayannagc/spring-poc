package com.example.comettestproject.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

@Data
@JacksonXmlRootElement(localName = "soapenv:Body")
public class SoapBody {

    @JacksonXmlProperty(localName = "req:Header")
    private XmlHeader xmlHeader;
    @JacksonXmlProperty(localName = "V11:opSendNotifRq")
    private SampleXmlObject sampleXmlObject;
}
