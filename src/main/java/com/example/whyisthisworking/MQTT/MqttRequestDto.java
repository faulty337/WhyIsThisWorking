package com.example.whyisthisworking.MQTT;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MqttRequestDto {
    private String[] topic;
    private String message;
}
