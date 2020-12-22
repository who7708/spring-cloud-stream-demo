package com.example.stream.rocketmq.producer.controller;

import com.example.stream.rocketmq.producer.messaging.TestMessaging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author Chris
 * @version 1.0.0
 * @date 2020/12/23
 */
@RestController
public class TestController {

    @Autowired
    private Source source;

    @GetMapping("/stream-test-msg")
    public TestMessaging streamTestMsg(String msg) {
        // 构建消息对象
        final TestMessaging testMessaging = TestMessaging.builder()
                .msgId(UUID.randomUUID().toString())
                .msgText(msg)
                .build();
        source.output().send(
                MessageBuilder.withPayload(testMessaging).build()
        );
        return testMessaging;
    }
}
