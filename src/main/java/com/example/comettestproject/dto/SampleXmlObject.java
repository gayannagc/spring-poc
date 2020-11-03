package com.example.comettestproject.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

@Data
@JacksonXmlRootElement(localName = "V11:opSendNotifRq")
public class SampleXmlObject {

    @JacksonXmlProperty(localName = "V11:firstString")
    private String stringField;
    @JacksonXmlProperty(localName = "V11:firstInt")
    private int intField;
//    @JacksonXmlProperty(localName = "V11:NameValuePairs")
//    private Map<String,Map<String,String>> mapField;
    @JacksonXmlElementWrapper(localName = "NameValuePairs")
    @JacksonXmlProperty(localName = "V11:NameValuePair")
    private List<Map<String,String>> listField;
    @JacksonXmlProperty
    private Timestamp timestampField;
}
