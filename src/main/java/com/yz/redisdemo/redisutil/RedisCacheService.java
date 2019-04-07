package com.yz.redisdemo.redisutil;

import org.springframework.data.redis.core.ZSetOperations;

import java.util.List;
import java.util.Set;

/**
 * @author yuzhou
 * @Description redis工具接口
 * @date created in 2018/11/21 14:20
 */
public interface RedisCacheService {
    /**
     * 写入缓存
     * @param key
     * @param value
     * @return
     */
     boolean set(final String key, Object value);

    /**
     * 写入缓存设置时效时间
     * @param key
     * @param value
     * @return
     */
    boolean set(final String key, Object value, Long expireTime);

    /**
     * 批量删除对应的value
     * @param keys
     */
    void remove(final String... keys);

    /**
     * 删除对应的value
     *
     * @param key
     */
     void remove(final String key);

    /**
     * 判断缓存中是否有对应的value
     * @param key
     * @return
     */
    boolean exists(final String key);

    /**
     * 读取缓存
     * @param key
     * @return
     */
    Object get(final String key);

    /**
     * 哈希 添加
     * @param key
     * @param hashKey
     * @param value
     */
    void hmSet(String key, Object hashKey, Object value);

    /**
     * 哈希获取数据
     * @param key
     * @param hashKey
     * @return
     */
    Object hmGet(String key, Object hashKey);

    /**
     * 列表添加
     * @param key
     * @param value
     */
    void lPush(String key, Object value);

    /**
     * 列表获取
     * @param key
     * @param l
     * @param l1
     * @return
     */
    List<Object> lRange(String key, long l, long l1);

    /**
     * 集合添加
     * @param key
     * @param value
     */
     void add(String key, Object value);

    /**
     * 集合获取
     * @param key
     * @return
     */
    Set<Object> setMembers(String key);

    /**
     * 有序集合添加
     * @param key
     * @param value
     * @param scoure
     */
    void zAdd(String key, Object value, double scoure);

    /**
     * 有序集合获取
     * @param key
     * @param scoure
     * @param scoure1
     * @return
     */
    Set<Object> rangeByScore(String key, double scoure, double scoure1);

    /**
     * 有序集合获取排名
     *
     * @param key 集合名称
     * @param value 值
     */
    Long zRank(String key, Object value);

    /**
     * 有序集合获取排名
     * @param key
     * @param start
     * @param end
     * @return
     */
    Set<ZSetOperations.TypedTuple<Object>> zRankWithScore(String key, long start, long end);

    /**
     * 有序集合添加
     *
     * @param key
     * @param value
     */
    Double zSetScore(String key, Object value);

    /**
     * 有序集合添加分数
     * @param key
     * @param value
     * @param scoure
     */
    void incrementScore(String key, Object value, double scoure);

    /**
     * 有序集合获取排名
     * @param key
     * @param start
     * @param end
     * @return
     */
    Set<ZSetOperations.TypedTuple<Object>> reverseZRankWithScore(String key, long start, long end);

}
