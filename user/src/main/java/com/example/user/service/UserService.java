package com.example.user.service;

import com.example.commonresource.entity.User;
import com.github.pagehelper.PageInfo;

public interface UserService {




    PageInfo<User> getByPage();



}
