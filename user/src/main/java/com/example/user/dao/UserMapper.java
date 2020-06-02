package com.example.user.dao;


import com.example.commonresource.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {


    @Select("select * from user")
    List<User> getAll();


}