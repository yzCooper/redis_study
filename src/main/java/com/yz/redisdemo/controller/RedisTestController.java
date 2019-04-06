package com.yz.redisdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuzhou
 * @Description  简单测试redis是否连接成功
 * @date created in 2019/3/26 16:43
 */
@RestController
public class RedisTestController {
    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping(value = "/test/redis")
    public String testredis(){
        redisTemplate.opsForValue().set("测试","yz");
        String result = (String)redisTemplate.opsForValue().get("测试");
        return result;
    }

}
