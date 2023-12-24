package com.example.whyisthisworking.kakao.block;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class KakaoBlockDescriptionContent implements KakaoBlockInterface {
    private String type;
    private String text;

}
