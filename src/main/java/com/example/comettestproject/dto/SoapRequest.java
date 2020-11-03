package com.example.comettestproject.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

@Data
@JacksonXmlRootElement(localName = "soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:req=\"http://schemas.xl.co.id/cle/namespace/Public/Common/RequestHeader.xsd\" xmlns:v1=\"http://schemas.xl.co.id/common/CommonResponse/V1.0\" xmlns:v11=\"http://schemas.xl.co.id/esb/payloads/Bil/SMSSurvey/V1.0\"")
public class SoapRequest {

    private SoapBody soapBody;
}
