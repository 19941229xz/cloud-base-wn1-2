package com.example.user.service;

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
    public PageInfo<User> getByPage() {


        PageHelper.startPage(1,10);

        List<User> userList =  userMapper.getAll();



        return new PageInfo<User>(userList);
    }
}
