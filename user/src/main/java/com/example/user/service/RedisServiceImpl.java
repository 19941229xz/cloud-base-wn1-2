package com.example.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisServiceImpl implements RedisService {


    @Autowired
    RedisTemplate redisTemplate;


    @Override
    public Object getKey(String key) {

        try {
            ValueOperations<String, String> operations = redisTemplate.opsForValue();
             return operations.get(key);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void setExpire(String key, String value, long expire) {
        try {
            ValueOperations<String, String> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            redisTemplate.expire(key, expire, TimeUnit.MILLISECONDS);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
