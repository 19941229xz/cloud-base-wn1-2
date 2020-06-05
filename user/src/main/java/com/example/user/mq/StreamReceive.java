package com.example.user.mq;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(StreamRabbitMq.class)
public class StreamReceive {




    @StreamListener(value = StreamRabbitMq.INPUT_2)
    @SendTo(value = StreamRabbitMq.INPUT_1)
    public String processInput1(String message){


        System.out.println("processInput1:"+message);

        return  "input2 is received!!";
    }


//    @StreamListener(value = StreamRabbitMq.INPUT_1)
//    public void processInput2(String message){
//
//
//        System.out.println("processInput2:"+message);
//
//    }


}
