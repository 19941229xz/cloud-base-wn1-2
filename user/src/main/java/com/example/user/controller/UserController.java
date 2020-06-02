package com.example.user.controller;


import com.example.commonresource.entity.MyRsp;
import com.example.commonresource.entity.Order;
import com.example.user.feign.OrderFeign;
import com.example.user.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {


    @Autowired
    OrderFeign  orderFeign;


    @Autowired
    UserServiceImpl userService;


    @GetMapping("/visitOrderHello")
    public Object visitOrderHello(){



        return MyRsp.success(orderFeign.visitOrderHello());
    }


    @PostMapping("/visitGetOrderHead")
    public Object visitGetOrderHead(@RequestBody Order order){

        System.out.println(order.toString());

        return MyRsp.success(orderFeign.getOrderHead(order));
    }


    @PostMapping("/getUserByPage")
    public Object getUserByPage(){


        return userService.getByPage();
    }

}
