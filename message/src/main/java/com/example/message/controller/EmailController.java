package com.example.message.controller;


import com.example.commonresource.entity.MyRsp;
import com.example.commonresource.entity.TextEmailEntity;
import com.example.message.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {


    @Autowired
    EmailService emailService;


    @PostMapping("/sendTextEmail")
    public Object sendTextEmail(@RequestBody TextEmailEntity emailEntity){


        emailService.sendTextMail(emailEntity);

        return MyRsp.success("发送成功");
    }



}
