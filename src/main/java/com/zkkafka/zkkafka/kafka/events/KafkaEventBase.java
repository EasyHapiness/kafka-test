package com.zkkafka.zkkafka.kafka.events;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @Desc
 * @Author
 * @Date 2019/7/26
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(fluent = true)
@Builder
public class KafkaEventBase {

    @JsonProperty("content")
    private String content;

    @JsonIgnore
    public String getEventType() {
        return this.getClass().getSimpleName();
    }
}
