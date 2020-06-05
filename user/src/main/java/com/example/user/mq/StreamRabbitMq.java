package com.example.user.mq;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface StreamRabbitMq {


    String INPUT_1 = "input1";

    String INPUT_2 = "input2";


    @Input(StreamRabbitMq.INPUT_1)
    SubscribableChannel input();

    @Output(StreamRabbitMq.INPUT_2)
    MessageChannel output();

}
