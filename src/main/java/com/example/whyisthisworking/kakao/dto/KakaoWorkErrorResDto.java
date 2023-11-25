package com.example.whyisthisworking.kakao.dto;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class KakaoWorkErrorResDto {
    private String message;
    private String code;
}
