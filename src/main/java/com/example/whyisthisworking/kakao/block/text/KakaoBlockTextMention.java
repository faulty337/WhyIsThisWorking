package com.example.whyisthisworking.kakao.block.text;

import com.example.whyisthisworking.kakao.enums.TextType;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class KakaoBlockTextMention implements KakaoBlockTextInlines{
    private final TextType type = TextType.LINK;
    private String text;
    private KakaoBlockReference ref;

    public KakaoBlockTextMention(String text, KakaoBlockReference ref) {
        this.text = text;
        this.ref = ref;
    }
}
