package com.green.greengramver5.feed.like;

import com.green.greengramver5.feed.like.model.FeedLikeReq;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FeedLikeService {
    private final FeedLikeMapper mapper;

    public int feedLikeToggle(FeedLikeReq p) {
        int result = mapper.delFeedLike(p);
        if (result == 0) {
            return mapper.insFeedLike(p); //좋아요 등록이 되었을 때 return 1
        }
        return 0; //좋아요 취소가 되었을 때 return 0
    }
}
