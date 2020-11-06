package com.example.comettestproject.dto.smssurvey;


import com.example.comettestproject.util.constants.Constants;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;
import lombok.ToString;

import java.util.List;
import java.util.Map;

@Data
@ToString
@JacksonXmlRootElement(localName = Constants.V11 + "opSendNotifRq")
public class SmsSurveyRq {

    @JacksonXmlProperty(localName = Constants.V11 + "MSISDN")
    private String msisdn;
    @JacksonXmlProperty(localName = Constants.V11 + "TIMESTAMP")
    private String timeStamp;
    @JacksonXmlProperty(localName = Constants.V11 + "SERIAL_NO")
    private String serialNo;
    @JacksonXmlProperty(localName = Constants.V11 + "S_REASON_1")
    private String reason1;
    @JacksonXmlProperty(localName = Constants.V11 + "S_REASON_2")
    private String reason2;
    @JacksonXmlProperty(localName = Constants.V11 + "S_REASON_3")
    private String reason3;
    @JacksonXmlProperty(localName = Constants.V11 + "SUPERVISOR")
    private String supervisor;
    @JacksonXmlProperty(localName = Constants.V11 + "WORK_GROUP")
    private String workGroup;
    @JacksonXmlProperty(localName = Constants.V11 + "PROD_TYPE")
    private String prodType;
    @JacksonXmlProperty(localName = Constants.V11 + "CUST_TYPE")
    private String custType;
    @JacksonXmlProperty(localName = Constants.V11 + "CREATED_BY")
    private String createdBy;
    @JacksonXmlProperty(localName = Constants.V11 + "FULLNAME")
    private String fullName;
    @JacksonXmlProperty(localName = Constants.V11 + "DIRECTION")
    private String direction;
    @JacksonXmlElementWrapper(localName = Constants.V11 + "NameValuePairs")
    @JacksonXmlProperty(localName = Constants.V11 + "NameValuePair")
    private List<Map<String,String>> nameValuePairs;

}
