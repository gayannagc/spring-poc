package com.example.comettestproject.dto.smssurvey;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@JacksonXmlRootElement(localName = "soapenv:Envelope")
public class SmsSurveyEnv {


    @JacksonXmlProperty(localName = "xmlns:soapenv",isAttribute = true)
    private String xmlnsEnv;

    @JacksonXmlProperty(localName = "xmlns:req",isAttribute = true)
    private String xmlnsReq;

    @JacksonXmlProperty(localName = "xmlns:v1",isAttribute = true)
    private String xmlnsV1;

    @JacksonXmlProperty(localName = "xmlns:v11",isAttribute = true)
    private String xmlnsV11;

    public SmsSurveyEnv() {
    }

    public SmsSurveyEnv(String xmlnsEnv, String xmlnsReq, String xmlnsV1, String xmlnsV11) {
        this.xmlnsEnv = xmlnsEnv;
        this.xmlnsReq = xmlnsReq;
        this.xmlnsV1 = xmlnsV1;
        this.xmlnsV11 = xmlnsV11;
    }

    @JacksonXmlProperty(localName = "soapenv:Header")
    private SmsSurveySoapHeader xmlHeader;
    @JacksonXmlProperty(localName = "soapenv:Body")
    private SmsSurveyBody smsSurveyBody;

}
