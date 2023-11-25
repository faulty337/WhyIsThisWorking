package com.example.whyisthisworking.kakao.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TextColor {
    DEFAULT("default"),
    RED("red"),
    BLUE("blue"),
    GREY("grey");

    private final String value;

    @JsonValue
    public String getValue(){
        return value;
    }
}
