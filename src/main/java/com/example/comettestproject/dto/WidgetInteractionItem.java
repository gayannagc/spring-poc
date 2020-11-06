package com.example.comettestproject.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@ToString
public class WidgetInteractionItem {
    private String itemId;
    @NotNull(message = "note")
    private List<String> note;
    @NotNull(message = "reason1")
    private String reason1;
    @NotNull(message = "reason2")
    private String reason2;
    @NotNull(message = "reason3")
    private String reason3;
    private String endTime;
    private String startTime;
    private String entityRefType;
    private String entityRefId;


}
