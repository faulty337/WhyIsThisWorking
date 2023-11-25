package com.example.whyisthisworking.kakao.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum HeaderStyle {
    WHITE("white"),
    BLUE("blue"),
    RED("ted"),
    YELLOW("yellow");

    private final String value;

    @JsonValue
    public String getValue(){
        return value;
    }
}
