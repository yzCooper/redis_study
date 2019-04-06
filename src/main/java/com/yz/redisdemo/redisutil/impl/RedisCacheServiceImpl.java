package com.yz.redisdemo.redisutil.impl;

import com.yz.redisdemo.redisutil.RedisCacheService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author yuzhou
 * @Description redis工具实现类
 * @date created in 2018/11/21 14:20
 */
@Service
@SuppressWarnings("unchecked")
public class RedisCacheServiceImpl implements RedisCacheService {
    private static final Logger LOG = LoggerFactory.getLogger(RedisCacheServiceImpl.class);

    @Autowired
    StringRedisTemplate redisTemplate;

    @Override
    public boolean hasKey(final String  key) {
        boolean result = false;
        try {
            result = redisTemplate.hasKey(key);
        } catch (Exception e) {
            LOG.error("判断redis缓存中是否有对应的key失败！错误信息为：" + e.getMessage());
        }
        return result;
    }

    @Override
    public boolean setString(String key, String value) {
        boolean result = false;
        try{
            redisTemplate.opsForValue().set(key , value);
            result = true;
        }catch (Exception e){
            LOG.error("redis缓存中插入String类型KEY,VAULE失败！错误信息为：" + e.getMessage());
        }
        return result;
    }

    @Override
    public boolean setExpireString(String key, String value, Long expire) {
        boolean result = false;
        try{
            redisTemplate.opsForValue().set(key , value);
            redisTemplate.expire(key, expire, TimeUnit.MINUTES);
            result = true;
        }catch(Exception e){
            LOG.error("redis缓存中插入（带存活时间）String类型KEY,VAULE失败！错误信息为：" + e.getMessage());
        }
        return result;
    }

    @Override
    public <T> T getString(String key) {
         T result  = null ;
        try{
             result = (T) redisTemplate.opsForValue().get(key);
        }catch (Exception e){
            LOG.error("redis缓存中通过KEY获取VAULE失败！错误信息为：" + e.getMessage());
        }
        return result;
    }
}
