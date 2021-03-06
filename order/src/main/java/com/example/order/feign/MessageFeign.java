package com.example.order.feign;


import com.example.commonresource.entity.MyRsp;
import com.example.commonresource.entity.TextEmailEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "message", fallback = MessageFeignFallBack.class)
public interface MessageFeign {




    @RequestMapping("/sendTextEmail")
    public MyRsp sendTextEmail(TextEmailEntity textEmailEntity);


}
