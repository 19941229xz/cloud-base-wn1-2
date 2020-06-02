package com.example.order.controller;


import com.example.commonresource.entity.MyRsp;
import com.example.commonresource.entity.Order;
import com.example.order.service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


@RestController
public class OrderController {


    @Value("${server.port}")
    private int port;


    @Value("${spring.application.name}")
    private String appName;


    @Value("${eureka.client.region}")
    private String region;

    @Value("${eureka.instance.metadata-map.zone}")
    private String zone;


    @Autowired
    OrderServiceImpl orderService;


    @GetMapping("/hello")
    public Object hello() {



        return MyRsp.success("我是："+appName+" 我的端口是："+port+" 所在区域："+region+" 所在机房："+zone);
    }


    @PostMapping("/getOrderHead")
    public Object getOrderHead(@RequestBody Order order){


        System.out.println(order.toString());

        return MyRsp.success(new Order(order.getOrderId(),"这是订单的概要信息",new Date()));

    }



    @PostMapping("/getByPage")
    public Object getByPage(){


        return MyRsp.success(orderService.getByPage());
    }



}
