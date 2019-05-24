package com.aaron.config.email;

import org.beetl.core.GroupTemplate;
import org.beetl.core.resource.ClasspathResourceLoader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.io.IOException;

/**
 * @author: lfl
 * @description: 邮件配置
 * @date: Create in 2019/5/23 下午 04:43
 */
@Configuration
@ComponentScan(value = "com.aaron.utils")
public class EmailConfig {

    @Value("${spring.mail.host}")
    private String host;

    @Value("${spring.mail.username}")
    private String username;

    @Value("${spring.mail.password}")
    private String authWord;

    /**
     * 在这里可以声明不同的邮件服务器主机，
     * 通常是SMTP主机,而具体的用户名和时授权码则建议在业务中从数据库查询
     *
     * @return
     */
    @Bean(name = "mainSender")
    JavaMailSenderImpl javaMailSender() {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost(host);
        // 设置发送人邮箱和授权码
        javaMailSender.setUsername(username);
        javaMailSender.setPassword(authWord);
        return javaMailSender;
    }

    /**
     * 配置模板引擎
     *
     * @return
     * @throws IOException
     */
    @Bean
    GroupTemplate groupTemplate() throws IOException {
        // 指定加载模板资源的位置 指定在classpath:beetl下
        ClasspathResourceLoader loader = new ClasspathResourceLoader("beetl");
        // beetl配置 这里采用默认的配置
        org.beetl.core.Configuration configuration = org.beetl.core.Configuration.defaultConfiguration();
        return new GroupTemplate(loader, configuration);
    }
}
