package com.example.whyisthisworking.kakao.block;

import com.example.whyisthisworking.kakao.enums.HeaderStyle;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class KakaoBlockHeader implements KakaoBlockInterface {
    private final String type = "header";
    private String text;
    private HeaderStyle style;

    public KakaoBlockHeader(String text, HeaderStyle style){
        this.text = text;
        this.style = style;
    }

    public KakaoBlockHeader(String text){
        this.text = text;
    }

}
