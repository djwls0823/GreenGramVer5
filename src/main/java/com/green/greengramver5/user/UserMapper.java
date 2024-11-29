package com.green.greengramver5.user;

import com.green.greengramver5.user.model.UserSignInReq;
import com.green.greengramver5.user.model.UserSignInRes;
import com.green.greengramver5.user.model.UserSignUpReq;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserMapper {
    int insUser(UserSignUpReq p);
    UserSignInRes selUserByUid(String uid);
}
