package com.aaron.interfaces;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author: lfl
 * @description:
 * @date: Create in 2019/5/2 下午 01:23
 * <p>
 * HK 指以hash结构操作时 键类型
 * T 为数据实体 应实现序列化接口,并定义serialVersionUID * RedisTemplate 提供了五种数据结构操作类型 hash / list / set / zset / value
 * 方法命名格式为 数据操作类型 + 操作 如 hashPut 指以hash结构(也就是map)想key添加键值对
 */
public interface RedisHelper<HK, T> {

    /**
     * Hash结构添加元素
     *
     * @param key
     * @param hashKey
     * @param domain
     */
    void hashPut(String key, HK hashKey, T domain);

    /**
     * Hash结构获取指定key所有键值对
     *
     * @param key
     * @return
     */
    Map<HK, T> hashFindAll(String key);

    /**
     * Hash结构获取单个元素
     *
     * @param key
     * @param hashKey
     * @return
     */
    T hashGet(String key, HK hashKey);

    /**
     * 移除方法
     *
     * @param key
     * @param hashKey
     */
    void hashRemove(String key, HK hashKey);

    /**
     * List结构向尾部(Right)添加元素
     *
     * @param key
     * @param domain
     * @return
     */
    Long rightPush(String key, T domain);

    /**
     * List结构向头部(Left)添加元素
     *
     * @param key
     * @param domain
     * @return
     */
    Long leftPush(String key, T domain);

    /**
     * List结构获取所有元素
     *
     * @param key
     * @return
     */
    List<T> listFindAll(String key);

    /**
     * List结构移除并获取数组第一个元素
     *
     * @param key
     * @return
     */
    T listLPop(String key);

    /**
     * 对象的实体类
     *
     * @param key
     * @param domain
     * @return
     */
    void valuePut(String key, T domain);

    /**
     * 获取对象实体类
     *
     * @param key
     * @return
     */
    T getValue(String key);

    /**
     * 移除key值
     *
     * @param key
     */
    void remove(String key);

    /**
     * 设置过期时间
     *
     * @param key
     * @param timeout
     * @param timeUnit
     * @return
     */
    boolean expires(String key, long timeout, TimeUnit timeUnit);
}
