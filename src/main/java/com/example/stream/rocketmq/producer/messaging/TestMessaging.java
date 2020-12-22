package com.example.stream.rocketmq.producer.messaging;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Chris
 * @version 1.0.0
 * @date 2020/12/23
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TestMessaging implements Serializable {
    private static final long serialVersionUID = -2024932036563515985L;
    private String msgId;
    private String msgText;
}
