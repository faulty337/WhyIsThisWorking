package com.example.whyisthisworking.kakao.block;


import com.example.whyisthisworking.kakao.enums.ButtonStyle;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
public class KakaoBlockButton implements KakaoBlockInterface {

    private String type = "button";
    private String text;
    private ButtonStyle style;
    private KakaoBlockButtonAction action;

    public KakaoBlockButton(String text, ButtonStyle style, KakaoBlockButtonAction action) {
        this.text = text;
        this.style = style;
        this.action = action;
    }

    public KakaoBlockButton(String text, ButtonStyle style, String name, String url) {
        this.text=text;
        this.style= style;
        this.action = new KakaoBlockButtonAction("open_system_browser", name, url);
    }

}
