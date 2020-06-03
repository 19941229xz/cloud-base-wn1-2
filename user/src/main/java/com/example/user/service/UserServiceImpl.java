package com.example.user.service;

import com.example.commonresource.entity.MyParam;
import com.example.commonresource.entity.User;
import com.example.user.dao.UserMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    UserMapper userMapper;

    @Override
    public PageInfo<User> getByPage(MyParam<User> param) {


        PageHelper.startPage(param.getPageParam().getPageNum(), param.getPageParam().getPageSize());

        String[] orderParams = param.getOrderParam();

        for (int i = 0; i < orderParams.length; i++) {


            PageHelper.orderBy(orderParams[i]);

        }

        List<User> userList = userMapper.getAll(param.getT());


        return new PageInfo<User>(userList);
    }


    @Override
    public int addOne(User user) {


        return userMapper.addOne(user);
    }
}
