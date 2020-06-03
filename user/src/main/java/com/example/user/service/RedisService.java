package com.example.user.service;

public interface RedisService {




    public void setExpire(String key, String value, long expire);


    public Object getKey(String key);


}
