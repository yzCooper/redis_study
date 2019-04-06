package com.yz.redisdemo.redisutil;

/**
 * @author yuzhou
 * @Description redis工具接口
 * @date created in 2018/11/21 14:20
 */
public interface RedisCacheService {
    /**
     * 判断key是否存在
     * @param key
     * @return boolean
     */
    boolean hasKey(String key);

    /**
     * 设置key,value,value 为String类型，不设置存活时间
     * @param key
     * @param value
     * @return boolean
     */
    boolean setString(String key, String value);

    /**
     * 设置key,value,value 为String类型，设置存活时间
     * @param key
     * @param value
     * @param expire 分钟
     * @return
     */
    boolean setExpireString(String key, String value, Long expire);

    /**
     * 通过key 获取redis中的值
     * @param key
     * @return Object
     */
    <T> T getString(String key);

}
