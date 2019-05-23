package com.aaron.redistest;

import com.aaron.entity.po.UserInfo;
import com.aaron.interfaces.interfacesimpl.RedisHelperImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: lfl
 * @description: Redis测试类
 * @date: Create in 2019/5/2 下午 01:02
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    private RedisHelperImpl redisHelper;

    @Test
    public void redisHelperTest() throws Exception {
        UserInfo userInfo = UserInfo.builder()
                .id(4)
                .userName("baobao")
                .passWord("123456")
                .realName("宝宝")
                .build();
        redisHelper.valuePut("1", userInfo.toString());
        System.out.println(redisHelper.getValue("1"));
    }
}
