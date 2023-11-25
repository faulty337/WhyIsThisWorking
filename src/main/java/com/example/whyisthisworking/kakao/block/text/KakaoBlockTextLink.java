package com.example.whyisthisworking.kakao.block.text;

import com.example.whyisthisworking.kakao.enums.TextType;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class KakaoBlockTextLink implements KakaoBlockTextInlines{
    private final TextType type = TextType.LINK;
    private String text;
    private String utl;

    public KakaoBlockTextLink(String text, String utl) {
        this.text = text;
        this.utl = utl;
    }
}
