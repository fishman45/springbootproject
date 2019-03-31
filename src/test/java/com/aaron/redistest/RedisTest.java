package com.aaron.redistest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void operateString() {
        stringRedisTemplate.opsForValue().set("author", "lifeilong");
        String value = stringRedisTemplate.opsForValue().get("author");
        System.out.println(value);
    }

    @Test
    public void operateList() {
        String key = "website";
        ListOperations<String, String> listOperations = stringRedisTemplate.opsForList();
        // 从左压入栈
        listOperations.leftPush(key, "Github");
        listOperations.leftPush(key, "CSDN");
        // 从右压入栈
        listOperations.rightPush(key, "SVN");
        List<String> list = listOperations.range(key, 0, 2);
        System.out.println(list);
    }
}
