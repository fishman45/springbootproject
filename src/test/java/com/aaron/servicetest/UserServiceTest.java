package com.aaron.servicetest;

import com.aaron.entity.po.UserInfo;
import com.aaron.services.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author: lfl
 * @description:
 * @date: Create in 2019/4/21 上午 10:42
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
    @Autowired
    UserService userService;

    @Test
    public void selectOne() {
        UserInfo user = UserInfo.builder().id(1).build();
        System.out.println(userService.selectOne(user));
    }

    @Test
    public void selectAll() {
        List<UserInfo> userList = userService.selectAll();
        System.out.println(userList);
    }
}
