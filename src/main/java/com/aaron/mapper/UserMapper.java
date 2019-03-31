package com.aaron.mapper;

import com.aaron.entity.User;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.BaseMapper;

@Repository
public interface UserMapper extends BaseMapper<User> {
    User getUser(int id);
}