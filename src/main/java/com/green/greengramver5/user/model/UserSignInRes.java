package com.green.greengramver5.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSignInRes {
    private long userId;
    private String nickName;
    private String pic;
    @JsonIgnore
    private String upw;
    @JsonIgnore // swagger표시 안되지만, 응답 때 빼는 역할도 한다.
    private String message;
}
