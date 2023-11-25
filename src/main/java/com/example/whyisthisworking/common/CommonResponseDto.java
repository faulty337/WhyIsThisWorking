package com.example.whyisthisworking.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;


@NoArgsConstructor
@Getter
public class CommonResponseDto<T> {
    private Integer status;
    private String message;
    private T data;

    private LocalDateTime timestamp = LocalDateTime.now();

    public CommonResponseDto(String message, T data) {
        this.status = HttpStatus.OK.value();
        this.message = message;
        this.data = data;
    }

    public CommonResponseDto(Integer status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }


    public HttpStatus extractHttpStatus() {
        try{
            return HttpStatus.valueOf(status);
        }catch (IllegalArgumentException e){
            return HttpStatus.OK;
        }

    }
}

