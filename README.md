# kafka-test
此代码可以拥有正式的生产环境，只不过采用的是单台kafka，groupId也为同一个（可以简单的理解为不同的groupId为不同的消息队列，只是同一个groupId
下面的有多个topic）


还有本文注释掉了KafkaTopicAdEventConsumer类下面的//@KafkaListener(topics = "#{kafkaConfigs.kafkaTopicTestEvent}")，
如果是同一个工程里面为了测试可以将本行代码放开，不同的工程，可以把kafka下面的beans包，config包，consumer包拷贝到另一个工程
里面就可以了。因为是测试采用了消息内容为string类型，kafka下面建立了一个events里面包含了一个公共的KafkaEventBase,可以采用构建者模式建立自己的相关
kafaka事件，但是请注意：KafkaEventBase里面的属性请加上@JsonProperty("content")注解，因为在启动的KafkaBeans里面默认采用了使用JsonDeserializer
反序列化消息，需要配置这个信任包否则会报错。



kafka内部会对消息的重复消费，以及消息丢失等做相关处理，可以保证同一个groupId下面的同一个topic只会被消费一次，kafka本身会对消息进行持久化操作，
已防消息丢失。至于原理说实话，我不是很清楚。
