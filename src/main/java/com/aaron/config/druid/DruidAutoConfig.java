package com.aaron.config.druid;

import com.aaron.entity.common.Druid;
import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author: lfl
 * @description: 连接池配置_1
 * @date: Create in 2019/4/21 上午 10:42
 */
@Configuration
@EnableConfigurationProperties(Druid.class)
@ConditionalOnClass(DruidDataSource.class)
@ConditionalOnProperty(prefix = "druid", name = "url")
@AutoConfigureBefore(DataSourceAutoConfiguration.class)
public class DruidAutoConfig {
    @Autowired
    private Druid druid;

    @Bean
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(druid.getUrl());
        dataSource.setUsername(druid.getUsername());
        dataSource.setPassword(druid.getPassword());
        if (druid.getInitialSize() > 0) {
            dataSource.setInitialSize(druid.getInitialSize());
        }
        if (druid.getMinIdle() > 0) {
            dataSource.setMinIdle(druid.getMinIdle());
        }
        if (druid.getMaxActive() > 0) {
            dataSource.setMaxActive(druid.getMaxActive());
        }
        dataSource.setTestOnBorrow(druid.isTestOnBorrow());
        try {
            dataSource.init();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return dataSource;
    }
}
