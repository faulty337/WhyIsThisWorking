package com.example.whyisthisworking.kakao;

import com.example.whyisthisworking.common.CommonResponseDto;
import com.example.whyisthisworking.kakao.dto.KakaoWorkMessageReqDto;
import com.example.whyisthisworking.kakao.dto.SendKakaoMessageReqDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/kakao")
public class KakaoContorller {

    private final KakaoService kakaoService;

    @PostMapping("/work/send-message")
    public ResponseEntity<CommonResponseDto<KakaoWorkMessageReqDto>> sendKakaoWorkMessage(@RequestBody SendKakaoMessageReqDto sendKakaoMessageReqDto){
        KakaoWorkMessageReqDto response = kakaoService.sendKakaoMessage(sendKakaoMessageReqDto.getHeaderText(), sendKakaoMessageReqDto.getHeaderStyle());
        return new ResponseEntity<>(new CommonResponseDto<>("Success Response", response), HttpStatus.OK);
    }
}
