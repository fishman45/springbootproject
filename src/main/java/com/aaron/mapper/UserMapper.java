package com.aaron.mapper;

import com.aaron.entity.po.UserInfo;
import com.aaron.interfaces.CommonMapper;
import org.springframework.stereotype.Repository;

/**
 * @author: lfl
 * @description: 用户mapper接口
 * @date: Create in 2019/5/2 下午 01:02
 */
@Repository
public interface UserMapper extends CommonMapper<UserInfo> {
}