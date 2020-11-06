package com.example.comettestproject.dto.smssurvey;


import com.example.comettestproject.util.constants.Constants;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@JacksonXmlRootElement(localName = "soapenv:Body")
public class SmsSurveyBody {
    @JacksonXmlProperty(localName = "req:Header")
    private SmsSurveyHeader smsSurveyHeader;
    @JacksonXmlProperty(localName =  Constants.V11 + "opSendNotifRq")
    private SmsSurveyRq smsSurveyRq;

}
