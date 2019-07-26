package com.zkkafka.zkkafka.kafka.service.impl;

import com.zkkafka.zkkafka.kafka.config.KafkaConfigs;
import com.zkkafka.zkkafka.kafka.events.KafkaEventBase;
import com.zkkafka.zkkafka.kafka.service.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Desc
 * @Author
 * @Date 2019/7/26
 */
@Component
public class KafkaServiceImpl implements KafkaService {


    @Resource
    KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    KafkaConfigs kafkaConfigs;

    @Override
    public void send(String content) {

        KafkaEventBase kafkaEventBase = KafkaEventBase.builder().content(content).build();
        kafkaTemplate.send(kafkaConfigs.getKafkaTopicTestEvent(),content);
    }
}
