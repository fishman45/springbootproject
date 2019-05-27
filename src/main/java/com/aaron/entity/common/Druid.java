package com.aaron.entity.common;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

/**
 * @author: lfl
 * @description: druid实体类
 * @date: Create in 2019/4/21 上午 10:42
 */
@Data
@ConfigurationProperties(prefix = "druid")
public class Druid {

    private String url;

    private String username;

    private String password;

    private String driverClass;

    private int maxActive;

    private int minIdle;

    private int initialSize;

    private boolean testOnBorrow;
}
