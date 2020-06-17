package com.example.springboottest.controller;

import com.example.springboottest.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {
    @Autowired
    RedisService redisService;

    @RequestMapping("setRedis")
    public String setRedis(String key, String value) {
        redisService.set(key, value);
        return "success";
    }

    @RequestMapping("getRedis")
    public String getRedis(String key) {
        return redisService.get(key);
    }
}
