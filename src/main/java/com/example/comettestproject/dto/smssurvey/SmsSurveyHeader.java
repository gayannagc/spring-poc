package com.example.comettestproject.dto.smssurvey;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@JacksonXmlRootElement(localName = "req:Header")
public class SmsSurveyHeader {
    @JacksonXmlProperty(localName = "req:ApplicationID")
    private String applicationId;
    @JacksonXmlProperty(localName = "req:EndSystem")
    private String endSystem;

    public SmsSurveyHeader() {
    }

    public SmsSurveyHeader(String applicationId, String endSystem) {
        this.applicationId = applicationId;
        this.endSystem = endSystem;
    }
}
