package com.example.user.controller;


import com.example.commonresource.entity.*;
import com.example.user.feign.MessageFeign;
import com.example.user.feign.OrderFeign;
import com.example.user.mq.StreamRabbitMq;
import com.example.user.service.RedisServiceImpl;
import com.example.user.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;

@CrossOrigin
@RestController
public class UserController {

    @Autowired
    MessageFeign messageFeign;

    @Autowired
    StreamRabbitMq streamRabbitMq;


    @Autowired
    OrderFeign orderFeign;


    @Autowired
    RedisServiceImpl redisService;


    @Autowired
    UserServiceImpl userService;


    @GetMapping("/visitOrderHello/{num}")
    public Object visitOrderHello(@PathVariable("num") int num) {

        System.out.println(num);

        return orderFeign.visitOrderHello();
    }


    @PostMapping("/visitGetOrderHead")
    public Object visitGetOrderHead(@RequestBody Order order) {

        System.out.println(order.toString());

        return MyRsp.success(orderFeign.getOrderHead(order));
    }


    @PostMapping("/getUserByPage")
    public Object getUserByPage(@RequestBody @Valid MyParam<User> param) {


        return MyRsp.success(userService.getByPage(param));
    }


    /**
     * 获取验证码的接口
     */
    @PostMapping("/getPhoneCode")
    public MyRsp getPhoneCode(@RequestBody MyParam<PhoneMsgEntity> param) {


        System.out.println(param.toString());

        return messageFeign.sendPhoneMsg(param);
    }

    /**
     * 短信验证码登录
     */
    @PostMapping("/loginWithPhoneCode")
    public MyRsp loginWithPhoneCode(@RequestBody MyParam<PhoneMsgEntity> param) {

        String code = (String) redisService.getKey(param.getT().getPhoneNum());  //redis里面的验证码

        //用户输入的验证码
        String userCode = param.getT().getCode();


        boolean isLoginSuccess = userCode.equals(code);

        if (isLoginSuccess) {

            redisService.delete(param.getT().getPhoneNum());

            return MyRsp.success("登录成功");
        } else {
            return MyRsp.fail().msg("登录失败");
        }
    }


    /**
     * 测试 mq
     */
    @GetMapping("/testMq")
    public MyRsp testMq() {

        streamRabbitMq.output().send(MessageBuilder.withPayload("now:"+new Date()).build());

        return MyRsp.success("mq send success!");
    }

}
