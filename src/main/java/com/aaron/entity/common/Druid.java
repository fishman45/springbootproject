package com.aaron.entity.common;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author: lfl
 * @description: druid实体类
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