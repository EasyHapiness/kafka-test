package com.zkkafka.zkkafka.kafka.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Desc
 * @Author
 * @Date 2019/7/25
 */
@Getter
@Component("kafkaConfigs")
public class KafkaConfigs {
    /**
     * 测试主题名
     */
    @Value("${spring.kafka.topic.name.test-event}")
    private String kafkaTopicTestEvent;

    /**
     * 缓存更新事件本机被分配的消费者组ID
     */
    @Value("${spring.kafka.topic.cache-refresh.consumer-group-id:}")
    private String kafkaTopicCacheRefreshCGID;

    @PostConstruct
    public void init() {
        if (kafkaTopicCacheRefreshCGID  == null) {
            this.kafkaTopicCacheRefreshCGID = String.format("kafka-group-id", 111111);
        }
    }
}
