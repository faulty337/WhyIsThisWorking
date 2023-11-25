package com.example.whyisthisworking.kakao;

import com.example.whyisthisworking.kakao.block.KakaoBlockHeader;
import com.example.whyisthisworking.kakao.dto.KakaoWorkMessageReqDto;
import com.example.whyisthisworking.kakao.enums.ColorStyle;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@Slf4j
@RequiredArgsConstructor
public class KakaoService {
    @Value("${kakao.work.bot.token}")
    private String kakaoBotToken;

    @Value("${kakao.work.roomId}")
    private String kakaoRoomId;


    public KakaoWorkMessageReqDto sendKakaoMessage(String headerText, ColorStyle headerStyle){
        KakaoWorkMessageReqDto requestDto = new KakaoWorkMessageReqDto(kakaoRoomId, headerText);
        KakaoBlockHeader header = new KakaoBlockHeader(headerText, headerStyle);
        requestDto.addBlock(header);

        publishKakaoBot(requestDto);

        return requestDto;
    }

    public void publishKakaoBot(KakaoWorkMessageReqDto requestDto){
        WebClient webClient = WebClient.create();

        Mono<Object> response = webClient.post()
                .uri("https://api.kakaowork.com/v1/messages.send")
                .header("Authorization", "Bearer " + kakaoBotToken)
                .header("Content-Type", "application/json")
                .bodyValue(requestDto)
                .retrieve()
                .bodyToMono(Object.class);

        response.subscribe(re -> {
            log.info(re.toString());
        });
    }
}
