package com.example.whyisthisworking.kakao.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.ToString;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class KakaoWorkResDto {
    private boolean success;
    private KakaoWorkMessageResDto message;
    private KakaoWorkErrorResDto error;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MyClass{");
        if (message != null) {
            sb.append("message='").append(message).append('\'');
        }
        if (error != null) {
            sb.append("error='").append(error).append('\'');
        }
        sb.append('}');
        return sb.toString();
    }
}
