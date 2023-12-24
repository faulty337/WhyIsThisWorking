package com.example.whyisthisworking.kakao.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ButtonStyle {
    DEFAULT("default"),
    PRIMARY("primary"),
    DANGER("danger");

    private final String value;

    @JsonValue
    public String getValue(){
        return value;
    }
}
