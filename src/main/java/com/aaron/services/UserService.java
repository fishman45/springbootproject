package com.aaron.services;

import com.aaron.entity.User;
import com.aaron.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public User getUser(int id) {
        return userMapper.getUser(id);
    }

    public List<User> getAll(){
        return userMapper.selectAll();
    }
}
