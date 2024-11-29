package com.green.greengramver5.feed.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class FeedGetRes {
    private long feedId;
    private String contents;
    private String location;
    private String createdAt;
    private long writerId;
    private String writerNm;
    private String writerPic;
    private int isLike;

    private List<String> pics = new ArrayList<>();
}
