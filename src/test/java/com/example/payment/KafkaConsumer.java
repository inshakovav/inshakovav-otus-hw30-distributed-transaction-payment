package com.example.payment;

import com.example.payment.dto.OrderCreatedMessage;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

@Component
@Slf4j
@Getter
public class KafkaConsumer {

    private CountDownLatch latch = new CountDownLatch(1);
    private String payload;
    private OrderCreatedMessage receivedMessage;

    @KafkaListener(topics = "hw30.order.created....", groupId = "my-group")
    public void receive(OrderCreatedMessage message) {
        log.info("received payload='{}'", message.toString());
//        payload = message.toString();
        receivedMessage = message;
        latch.countDown();
    }

    public void resetLatch() {
        latch = new CountDownLatch(1);
    }
}