package com.example.whyisthisworking.kakao.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TextType {
    STYLE("style"),
    LINK("link"),
    MENTION("mention");

    private final String value;

    @JsonValue
    public String getValue(){
        return value;
    }

}
