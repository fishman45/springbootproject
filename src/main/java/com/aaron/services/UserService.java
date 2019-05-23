package com.aaron.services;

import com.aaron.entity.po.UserInfo;

import java.util.List;

/**
 * @author: lfl
 * @description: 用户接口层
 * @date: Create in 2019/5/2 下午 01:02
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
