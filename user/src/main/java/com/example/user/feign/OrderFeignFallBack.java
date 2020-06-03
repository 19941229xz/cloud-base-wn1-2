package com.example.user.feign;

import com.example.commonresource.entity.MyRsp;
import com.example.commonresource.entity.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderFeignFallBack  implements  OrderFeign{


    @Override
    public MyRsp visitOrderHello() {

        //这里执行服务降级的操作
        //这里可以执行一些  消息通知操作




        return MyRsp.fail().code(50000).msg("订单服务走丢了。。。。。。");
    }

    @Override
    public MyRsp getOrderHead(Order order) {
        return null;
    }
}
