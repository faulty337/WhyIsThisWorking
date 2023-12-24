package com.example.whyisthisworking.kakao.block;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KakaoBlockDescription implements KakaoBlockInterface {
    private final String type= "description";
    private String term;
    private KakaoBlockDescriptionContent content;
    private Boolean accent;

    public KakaoBlockDescription(String term, String text) {
        this.term = term;
        this.content = new KakaoBlockDescriptionContent("text", text);
        this.accent = true;
    }
}
