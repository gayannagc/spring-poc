package com.example.comettestproject.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

@Data
@JacksonXmlRootElement(localName = "V11:NameValuePair")
public class SampleInnerObject {

    @JacksonXmlProperty(localName = "V11:name")
    private String name;
    @JacksonXmlProperty(localName = "V11:value")
    private String value;
}
