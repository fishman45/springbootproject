package com.aaron.interfaces;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author: lfl
 * @description: 公共TkMapper接口
 * @date: Create in 2019/4/21 上午 09:24
 */
public interface CommonMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
