package com.example.whyisthisworking.kakao.block;

import com.example.whyisthisworking.kakao.enums.ColorStyle;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class KakaoBlockHeader implements KakaoBlockInterface {
    private final String type = "header";
    private String text;
    private ColorStyle style;

    public KakaoBlockHeader(String text, ColorStyle style){
        this.text = text;
        this.style = style;
    }

    public KakaoBlockHeader(String text){
        this.text = text;
    }

}
