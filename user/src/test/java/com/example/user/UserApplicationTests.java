package com.example.user;

import com.example.commonresource.entity.User;
import com.example.user.dao.UserMapper;
import com.example.user.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class UserApplicationTests {


    @Autowired
    UserServiceImpl userService;


    @Autowired
    UserMapper  userMapper;

    @Test
    void contextLoads() {


//        for (int i = 0; i < 500; i++) {
//            userService.addOne(new User(i+2, "tom"+"-"+(i+2), (123+i)+""));
//        }


        User u = new User();


//        u.setName("tom");

       List<User> userList =  userMapper.getAll(u);

        for (User t:
             userList) {


            System.out.println(t.toString());


        }


    }

}
