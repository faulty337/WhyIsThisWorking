package com.example.whyisthisworking.kakao.dto;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class KakaoWorkMessageResDto{
    private String id;
    private String text;
    private Integer userId;
    private String conversation_id;
    private String sendTime;
    private String updateTime;
    private Object blocks;
}
