package com.example.whyisthisworking.common.config;

import com.example.whyisthisworking.MQTT.MqttService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.MessageProducer;
import org.springframework.integration.mqtt.core.DefaultMqttPahoClientFactory;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;
import org.springframework.integration.mqtt.outbound.MqttPahoMessageHandler;
import org.springframework.integration.mqtt.support.DefaultPahoMessageConverter;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.handler.annotation.Header;

import java.util.Random;

@Configuration
@RequiredArgsConstructor
@Slf4j
@Profile("!test")
public class MqttConfig {
    @Value("${mqttSetting.mqttUrl}")
    private String mqttUrl;
    @Value("${mqttSetting.subId}")
    private String subId;
    @Value("${mqttSetting.pubId}")
    private String pubId;


    private final ObjectMapper objectMapper = new ObjectMapper();

    private final MqttService mqttService;

    private final int leftLimit = 97; // letter 'a'
    private final int rightLimit = 122; // letter 'z'
    private final int targetStringLength = 6;

    private Random random = new Random();
    @Bean
    public MessageChannel mqttTestInputChannel() {
        return new DirectChannel();
    }

    public MqttPahoClientFactory mqttClientFactory(){
        DefaultMqttPahoClientFactory factory = new DefaultMqttPahoClientFactory();
        MqttConnectOptions options = new MqttConnectOptions();  // 옵션 설정 시작

        options.setServerURIs(new String[] {mqttUrl});  // mqtt와 연결할 url 옵션

        options.setMaxInflight(1000);

        options.setCleanSession(true);
        factory.setConnectionOptions(options);

        return factory;
    }

    @Bean
    public MessageProducer inboundTest(){
        return adapterSetting("whyIsThisWorking/test/#", mqttTestInputChannel());
    }



    @Bean
    @ServiceActivator(inputChannel = "mqttTestInputChannel")
    public MessageHandler inboundRobotMessageHandler() {
        return message -> {
            System.out.println("뜸!!!");
        };
    }


    @Bean
    @ServiceActivator(inputChannel = "mqttOutboundChannel")
    public MessageHandler mqttOutbound() {
        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        MqttPahoMessageHandler messageHandler = new MqttPahoMessageHandler(subId+generatedString, mqttClientFactory());
        messageHandler.setAsync(true);
        messageHandler.setDefaultRetained(false);
        messageHandler.setDefaultQos(1);

        return messageHandler;
    }


    @MessagingGateway(defaultRequestChannel = "mqttOutboundChannel")
    public interface OutboundGateway {
        void sendToMqtt(String payload, @Header(MqttHeaders.TOPIC) String topic);
    }

    private MqttPahoMessageDrivenChannelAdapter adapterSetting(String topic, MessageChannel channel){
        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        MqttPahoMessageDrivenChannelAdapter adapter = new MqttPahoMessageDrivenChannelAdapter(subId+generatedString,
                mqttClientFactory(),topic);
        adapter.setCompletionTimeout(5000);// 연결 기다림 시간
        adapter.setConverter(new DefaultPahoMessageConverter());
        adapter.setQos(1);// qos 설정
        adapter.setOutputChannel(channel);
        return adapter;
    }



}
