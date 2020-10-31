package com.example.comettestproject.dto.tokenDto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class UserCacheObject implements Serializable {

    private String uniqueId;
    private Long idleTimeRange;
}
