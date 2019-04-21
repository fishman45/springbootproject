package com.aaron.services.servicesimpl;

import com.aaron.entity.po.UserInfo;
import com.aaron.mapper.UserMapper;
import com.aaron.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: lfl
 * @Descripiton: 用户Service层
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
