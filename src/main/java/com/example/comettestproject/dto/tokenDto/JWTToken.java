package com.example.comettestproject.dto.tokenDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JWTToken {

    private String op;
    private String userName;
    private String uniqueId;
    private String hashName;
    private String lastActiveTime;
}
