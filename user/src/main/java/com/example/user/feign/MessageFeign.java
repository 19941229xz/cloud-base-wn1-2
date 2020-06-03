package com.example.user.feign;


import com.example.commonresource.entity.MyParam;
import com.example.commonresource.entity.MyRsp;
import com.example.commonresource.entity.PhoneMsgEntity;
import com.example.commonresource.entity.TextEmailEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "message", fallback = MessageFeignFallBack.class)
public interface MessageFeign {




    @RequestMapping("/sendTextEmail")
    public MyRsp sendTextEmail(TextEmailEntity textEmailEntity);



    @RequestMapping(method=RequestMethod.POST,value = "/sendPhoneMsg",consumes = "application/json",produces = "application/json")
//    public MyRsp sendPhoneMsg(PhoneMsgEntity param);
    public MyRsp sendPhoneMsg(MyParam<PhoneMsgEntity> param);


}
