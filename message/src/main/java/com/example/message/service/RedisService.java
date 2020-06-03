package com.example.message.service;

public interface RedisService {




    public void setExpire(String key ,String value , long expire);


}
