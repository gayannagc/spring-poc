package com.example.comettestproject.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class InteractionItem {

    private List<AttachmentRef> attachmentref;
    private List<Characteristic> characteristic;
    @NotNull
    private Map<String, String> extensions;
    private String id;
    private EntityRef item;
    private TimePeriod itemDate;
    @NotNull
    private List<Note> note;
    @NotNull
    private String reason;
    @NotNull
    private String resolution;

    @Override
    public String toString() {
        return super.toString();
    }
}
