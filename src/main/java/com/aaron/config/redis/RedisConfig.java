package com.aaron.config.redis;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

/**
 * @author: lfl
 * @description:
 * @date: Create in 2019/5/2 下午 01:02
 */
@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {

    private RedisConnectionFactory connectionFactory;

    /**
     * 自定义生成key的规则
     *
     * @return
     */
    @Override
    public KeyGenerator keyGenerator() {
        return (o, method, objects) -> {
            // 格式化缓存key字符串
            StringBuilder sb = new StringBuilder();
            // 追加类名
            sb.append(o.getClass().getName());
            // 追加方法名
            sb.append(method.getName());
            // 遍历参数并追加
            for (Object obj : objects) {
                sb.append(obj.toString());
            }
            System.out.println("调用Redis缓存Key:" + sb.toString());
            return sb.toString();
        };
    }

    /**
     * 采用RedisCacheManager作为缓存管理器
     *
     * @param connectionFactory
     * @return
     */
    @Bean
    public CacheManager cacheManager(RedisConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
        return RedisCacheManager.create(connectionFactory);
    }

    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {
        // 解决键、值序列化问题
        StringRedisTemplate template = new StringRedisTemplate(factory);
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        template.setValueSerializer(jackson2JsonRedisSerializer);
        template.afterPropertiesSet();
        return template;
    }
}