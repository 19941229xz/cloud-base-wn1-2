package com.example.message.controller;


import com.example.commonresource.entity.MyRsp;
import com.example.commonresource.entity.TextEmailEntity;
import com.example.message.service.EmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {


    @Autowired
    EmailServiceImpl emailServiceImpl;


    @PostMapping("/sendTextEmail")
    public Object sendTextEmail(@RequestBody TextEmailEntity emailEntity){
        System.out.println("test");

//        //模拟一个异常
//        System.out.println(1/0);

//        emailServiceImpl.sendTextMail(emailEntity);

        return MyRsp.success("发送成功");
    }



}
