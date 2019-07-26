package com.zkkafka.zkkafka.kafka.consumer;

import com.zkkafka.zkkafka.kafka.events.KafkaEventBase;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @Desc
 * @Author
 * @Date 2019/7/26
 */
@Component
//@KafkaListener(topics = "#{kafkaConfigs.kafkaTopicTestEvent}")
public class KafkaTopicAdEventConsumer {

    @KafkaHandler
    public void receive(String content) {

        System.out.println("kafka消费端接受到消费消息" + content);
    }
}
