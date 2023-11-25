package com.example.whyisthisworking.kakao.block.text;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class KakaoBlockText {
    private final String type = "text";
    private String text;
    private List<KakaoBlockTextInlines> inlines;

    public KakaoBlockText(String text, List<KakaoBlockTextInlines> inlines) {
        this.text = text;
        this.inlines = inlines;
    }
}
