package com.aaron.entity.common;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

/**
 * @author: lfl
 * @description: Email实体类
 * @date: Create in 2019/5/27 上午 09:36
 */
@Data
@ConfigurationProperties(prefix = "spring.mail")
public class Email {

    /**
     * smtp服务器地址
     */
    private String host;

    /**
     * 发送人邮箱
     */
    private String username;

    /**
     * 授权码
     */
    private String password;
}
