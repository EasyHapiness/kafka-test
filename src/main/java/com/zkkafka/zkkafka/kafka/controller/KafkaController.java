package com.zkkafka.zkkafka.kafka.controller;

import com.zkkafka.zkkafka.kafka.service.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Desc
 * @Author
 * @Date 2019/7/26
 */
@RestController
@RequestMapping("/test")
public class KafkaController {

    @Autowired
    KafkaService kafkaService;

    @RequestMapping("/kafka/{content}")
    public void getTestKafka(@PathVariable("content") String content){

        kafkaService.send(content);
    }
}
