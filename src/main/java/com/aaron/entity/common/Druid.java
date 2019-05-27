package com.aaron.entity.common;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author: lfl
 * @description: druid实体类
 * @date: Create in 2019/4/21 上午 10:42
 */
@Data
@ConfigurationProperties(prefix = "druid")
public class Druid {

    /**
     * 数据库连接地址
     */
    private String url;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 驱动类
     */
    private String driverClass;

    /**
     * 连接池的最大数据库连接数
     */
    private int maxActive;

    /**
     * 最小空闲数，数据库连接的最小空闲时间
     */
    private int minIdle;

    /**
     * 连接初始值,连接池启动时创建的连接数量的初始值
     */
    private int initialSize;

    /**
     * 检测池里连接的可用性，生产环境一般是不开启的,主要是性能考虑
     */
    private boolean testOnBorrow;
}
