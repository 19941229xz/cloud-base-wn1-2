package com.example.user.feign;

import com.example.commonresource.entity.MyParam;
import com.example.commonresource.entity.MyRsp;
import com.example.commonresource.entity.PhoneMsgEntity;
import com.example.commonresource.entity.TextEmailEntity;
import org.springframework.stereotype.Component;


@Component
public class MessageFeignFallBack implements MessageFeign {


    @Override
    public MyRsp sendPhoneMsg(MyParam<PhoneMsgEntity> param) {
        return MyRsp.fail().code(50000).msg("发送验证码失败");
    }

//    @Override
//    public MyRsp sendPhoneMsg(PhoneMsgEntity param) {
//        return MyRsp.fail().code(50000).msg("发送验证码失败");
//    }

    //实现降级方法
    @Override
    public MyRsp sendTextEmail(TextEmailEntity textEmailEntity) {




        return MyRsp.fail().code(50000).msg("消息服务：发邮件失败了...稍后青重试....");
    }
}
