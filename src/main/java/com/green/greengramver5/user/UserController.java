package com.green.greengramver5.user;

import com.green.greengramver5.common.model.ResultResponse;
import com.green.greengramver5.user.model.UserSignInReq;
import com.green.greengramver5.user.model.UserSignInRes;
import com.green.greengramver5.user.model.UserSignUpReq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("user")
public class UserController {
    private final UserService service;

    @PostMapping("sign-up")
    public ResultResponse<Integer> signUp(@RequestPart UserSignUpReq p, @RequestPart(required = false) MultipartFile pic) {
        int result = service.postSignUp(pic, p);
        return ResultResponse.<Integer>builder()
                .resultMessage("회원가입 완료")
                .resultData(result)
                .build();
    }

    @PostMapping("sign-in")
    public ResultResponse<UserSignInRes> signIn(@RequestBody UserSignInReq p) {
        UserSignInRes res = service.postSignIn(p);
        return ResultResponse.<UserSignInRes>builder()
                .resultMessage(res.getMessage())
                .resultData(res)
                .build();
    }
}
