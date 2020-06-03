package com.example.message.controller;


import com.example.commonresource.entity.MyParam;
import com.example.commonresource.entity.MyRsp;
import com.example.commonresource.entity.PhoneMsgEntity;
import com.example.message.service.PhoneMsgServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PhoneMsgController {


    @Autowired
    PhoneMsgServiceImpl phoneMsgService;


    @RequestMapping(value = "/sendPhoneMsg", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public MyRsp sendPhoneMsg(@RequestBody MyParam<PhoneMsgEntity> param) {
//        public MyRsp sendPhoneMsg(@RequestBody PhoneMsgEntity param) {


            System.out.println(param);

        phoneMsgService.sendPhoneMsg(param.getT().getPhoneNum());


        return MyRsp.success("发送成功");


    }


}
