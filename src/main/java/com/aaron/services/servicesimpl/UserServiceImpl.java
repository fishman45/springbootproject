package com.aaron.services.servicesimpl;

import com.aaron.entity.po.UserInfo;
import com.aaron.mapper.UserMapper;
import com.aaron.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: lfl
 * @description: 用户Service层
 * @date: Create in 2019/5/2 下午 01:02
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;


    @Override
    public UserInfo selectOne(UserInfo user) {
        return userMapper.selectOne(user);
    }

    @Override
    public List<UserInfo> selectAll() {
        return userMapper.selectAll();
    }
}
