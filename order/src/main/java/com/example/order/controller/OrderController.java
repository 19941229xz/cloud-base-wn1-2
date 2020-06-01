package com.example.order.controller;


import com.example.commonresource.entity.MyRsp;
import com.example.commonresource.entity.Order;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


@RestController
public class OrderController {


    @Value("${server.port}")
    private int port;


    @Value("${spring.application.name}")
    private String appName;


    @GetMapping("/hello")
    public Object hello() {



        return MyRsp.success("我是："+appName+" 我的端口是："+port);
    }


    @PostMapping("/getOrderHead")
    public Object getOrderHead(@RequestBody Order order){


        System.out.println(order.toString());

        return MyRsp.success(new Order(order.getOrderId(),"这是订单的概要信息",new Date()));

    }




}
