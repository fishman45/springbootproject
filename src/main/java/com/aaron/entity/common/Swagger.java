package com.aaron.entity.common;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

/**
 * @author: lfl
 * @description:
 * @date: Create in 2019/5/27 上午 10:50
 */
@Data
@ConfigurationProperties(prefix = "swagger")
public class Swagger {

    private boolean enable;
}
