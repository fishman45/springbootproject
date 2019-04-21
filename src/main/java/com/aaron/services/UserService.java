package com.aaron.services;

import com.aaron.entity.po.UserInfo;

import java.util.List;

/**
 * @Author: lfl
 * @Description: 用户接口层
 */
public interface UserService {

    /**
     * @return User
     * @description: 查询一条数据
     */
    UserInfo selectOne(UserInfo user);

    /**
     * @return List<User>
     * @description: 查询所有数据
     */
    List<UserInfo> selectAll();
}
