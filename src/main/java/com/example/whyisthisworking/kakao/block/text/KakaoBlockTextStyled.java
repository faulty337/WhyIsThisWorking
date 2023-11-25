package com.example.whyisthisworking.kakao.block.text;

import com.example.whyisthisworking.kakao.enums.TextColor;
import com.example.whyisthisworking.kakao.enums.TextType;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.w3c.dom.Text;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
public class KakaoBlockTextStyled implements KakaoBlockTextInlines{
    private final TextType type = TextType.STYLE;
    private String text;
    private Boolean bold;
    private Boolean italic;
    private Boolean strike;
    private TextColor color;

    public KakaoBlockTextStyled(String text, TextColor color, String... fieldNames) {
        this.text = text;
        this.color = color;
        for (String fieldName : fieldNames) {
            if ("bold".equals(fieldName)) {
                this.bold = true;
            } else if ("italic".equals(fieldName)) {
                this.italic = true;
            } else if ("strike".equals(fieldName)) {
                this.strike = true;
            }
        }
    }

    public KakaoBlockTextStyled(String text, String... fieldNames) {
        this.text = text;
        for (String fieldName : fieldNames) {
            if ("bold".equals(fieldName)) {
                this.bold = true;
            } else if ("italic".equals(fieldName)) {
                this.italic = true;
            } else if ("strike".equals(fieldName)) {
                this.strike = true;
            }
        }
    }

    public KakaoBlockTextStyled(String text, TextColor color) {
        this.text = text;
        this.color = color;
    }
}
