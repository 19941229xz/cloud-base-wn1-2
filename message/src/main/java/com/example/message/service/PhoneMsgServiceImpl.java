package com.example.message.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;

import java.util.Random;

@Service
public class PhoneMsgServiceImpl implements PhoneMsgService {


    @Autowired
    RedisServiceImpl redisService;


    public void sendPhoneMsg(String phoneNum){
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI4FyrvZQtmnQriUF3x8ui", "WnN61YbCd9sn7b5GK0beQu7a79meZJ");
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", phoneNum);
        request.putQueryParameter("SignName", "源码课堂");
        request.putQueryParameter("TemplateCode", "SMS_191768213");

        Random random = new Random();

        int num = random.nextInt(999999);

        request.putQueryParameter("TemplateParam", "{\"code\":\""+num+"\"}");
        try {
            CommonResponse response = client.getCommonResponse(request);

            /*
            * {"Message":"OK","RequestId":"99466C18-2384-4A01-A53B-12AF405696FF","BizId":"843802691174808643^0","Code":"OK"}
            * */


            boolean isSuccess = response.getData().indexOf("OK")>-1;

            redisService.setExpire(phoneNum, num+"", 1000*60*3);

//            System.out.println(response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }



}
