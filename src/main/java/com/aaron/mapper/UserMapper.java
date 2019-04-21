package com.aaron.mapper;

import com.aaron.entity.po.UserInfo;
import com.aaron.interfaces.CommonMapper;
import org.springframework.stereotype.Repository;

/**
 * @Author lfl
 * @Description 用户mapper接口
 */
@Repository
public interface UserMapper extends CommonMapper<UserInfo> {
}