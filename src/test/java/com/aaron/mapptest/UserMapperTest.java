package com.aaron.mapptest;

import com.aaron.entity.po.UserInfo;
import com.aaron.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: lfl
 * @description:
 * @date: Create in 2019/4/21 上午 09:25
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    UserMapper userMapper;

    @Test
    public void selectOne() {
        UserInfo user = UserInfo.builder().id(1).build();
        System.out.println(userMapper.selectOne(user));
    }

    @Test
    public void selectAll(){
        System.out.println(userMapper.selectAll());
    }
}