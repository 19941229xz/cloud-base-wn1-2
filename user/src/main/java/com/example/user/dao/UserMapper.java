package com.example.user.dao;


import com.example.commonresource.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {



    List<User> getAll(User user);

    @Insert("insert into user(id,name,pass)values(#{id},#{name},#{pass})")
    int addOne(User user);


}
