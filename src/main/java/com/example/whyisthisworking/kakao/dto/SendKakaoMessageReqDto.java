package com.example.whyisthisworking.kakao.dto;

import com.example.whyisthisworking.kakao.enums.HeaderStyle;
import lombok.Getter;

@Getter
public class SendKakaoMessageReqDto {
    private String headerText;
    private HeaderStyle headerStyle;
}
