package com.green.greengramver5.user.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserSignInReq {
    private String uid;
    private String upw;
}
