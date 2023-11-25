package com.example.whyisthisworking.kakao.block.text;


import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class KakaoBlockReference {
    private final String Type = "kw";
    private Integer value;

    public KakaoBlockReference(Integer value) {
        this.value = value;
    }
}
