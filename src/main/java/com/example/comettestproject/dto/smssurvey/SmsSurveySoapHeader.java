package com.example.comettestproject.dto.smssurvey;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@JacksonXmlRootElement(localName = "soapenv:Header")
public class SmsSurveySoapHeader {
}
