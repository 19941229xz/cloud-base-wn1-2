package com.example.user.feign;


import com.example.commonresource.entity.MyRsp;
import com.example.commonresource.entity.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 用来调用order微服务的feign客户端
 */
@FeignClient(name = "order")
public interface OrderFeign {


    @GetMapping("/hello")
    public MyRsp visitOrderHello();


    @RequestMapping(method = RequestMethod.POST,value = "/getOrderHead")
    public MyRsp getOrderHead(Order order);


}
