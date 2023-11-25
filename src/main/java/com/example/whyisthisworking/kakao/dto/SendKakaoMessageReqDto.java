package com.example.whyisthisworking.kakao.dto;

import com.example.whyisthisworking.kakao.enums.ColorStyle;
import lombok.Getter;

@Getter
public class SendKakaoMessageReqDto {
    private String headerText;
    private ColorStyle headerStyle;
}
