package com.green.greengramver5.feed;

import com.green.greengramver5.common.model.ResultResponse;
import com.green.greengramver5.feed.model.FeedGetReq;
import com.green.greengramver5.feed.model.FeedGetRes;
import com.green.greengramver5.feed.model.FeedPostReq;
import com.green.greengramver5.feed.model.FeedPostRes;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("feed")
public class FeedController {
    private final FeedService service;

    @PostMapping
    @Operation(summary = "피드 등록", description = "필수: 사진리스트 || 옵션: 위치, 내용")
    public ResultResponse<FeedPostRes> postFeed(@RequestPart List<MultipartFile> pics
                                              , @RequestPart FeedPostReq p) {
        FeedPostRes res = service.postFeed(pics, p);
        return ResultResponse.<FeedPostRes>builder()
                .resultMessage("피드 등록 완료")
                .resultData(res)
                .build();
    }

    @GetMapping
    @Operation(summary = "Feed 리스트", description = "loginUserId는 로그인한 사용자의 pk")
    public ResultResponse<List<FeedGetRes>> getFeedList(@ParameterObject @ModelAttribute FeedGetReq p) {
        log.info("FeedController > getFeedList > p: {}", p);
        List<FeedGetRes> list = service.getFeedList(p);
        return ResultResponse.<List<FeedGetRes>>builder()
                             .resultMessage(String.format("%d rows", list.size()))
                             .resultData(list)
                             .build();
    }
}
