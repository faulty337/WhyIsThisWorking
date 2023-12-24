package com.example.whyisthisworking.kakao.dto;

import com.example.whyisthisworking.kakao.block.KakaoBlockInterface;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class KakaoWorkMessageReqDto {
    private String conversation_id;
    private String text;
    private List<KakaoBlockInterface> blocks = new ArrayList<>();

    public KakaoWorkMessageReqDto(String conversation_id, String text){
        this.conversation_id = conversation_id;
        this.text = text;
    }
    public void addBlock(KakaoBlockInterface block){
        this.blocks.add(block);
    }
}
