package com.zkkafka.zkkafka.kafka.beans;

import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

/**
 * @Desc
 * @Author
 * @Date 2019/7/26
 */
@Configuration
public class KafkaBeans {


    @Autowired
    private KafkaProperties properties;

    @Bean
    public JsonDeserializer<Object> jsonDeserializer() {
        JsonDeserializer<Object> jsonDeserializer = new JsonDeserializer<>();
        // 使用JsonDeserializer反序列化消息需要配置这个信任包
        jsonDeserializer.addTrustedPackages("*");
        return jsonDeserializer;
    }

    @Bean
    public ConsumerFactory<String, Object> consumerFactory() {
        return new DefaultKafkaConsumerFactory<>(properties.getConsumer().buildProperties(), new StringDeserializer(),
                this.jsonDeserializer());
    }

    @Bean
    public KafkaListenerContainerFactory<?> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, Object> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(this.consumerFactory());
//        factory.setMessageConverter(new BytesJsonMessageConverter());
        return factory;
    }

}
