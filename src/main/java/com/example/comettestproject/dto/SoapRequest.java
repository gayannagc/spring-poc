package com.example.comettestproject.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

@Data
@JacksonXmlRootElement(localName = "soapenv:Envelope")
public class SoapRequest {

    @JacksonXmlProperty(localName = "xmlns:soapenv",isAttribute = true)
    private final String xmlnsEnv = "http://schemas.xmlsoap.org/soap/envelope/";
    @JacksonXmlProperty(localName = "xmlns:req",isAttribute = true)
    private final String xmlnsReq = "http://schemas.xl.co.id/cle/namespace/Public/Common/RequestHeader.xsd";
    @JacksonXmlProperty(localName = "soapenv:Header")
    private XmlHeader xmlHeader;
    @JacksonXmlProperty(localName = "soapenv:Body")
    private SoapBody soapBody;
}
