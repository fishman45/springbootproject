package com.aaron.servicetest;

import com.aaron.entity.User;
import com.aaron.services.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

    @Autowired
    UserService userService;

    @Test
    public void getUser(){
        User user = userService.getUser(1);
        System.out.println(user);
    }

    @Test
    public void getAllTest(){
        List<User> userList = userService.getAll();
        System.out.println(userList);
    }
}
