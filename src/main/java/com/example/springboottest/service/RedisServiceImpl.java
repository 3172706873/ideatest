package com.example.springboottest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Service
public class RedisServiceImpl implements RedisService{
    @Autowired
    JedisPool jedisPool;

    @Override
    public Jedis getResource() {
        return jedisPool.getResource();
    }

    @Override
    public void returnResource(Jedis jedis) {
        if (jedis != null)
            jedis.close();
    }

    @Override
    public void set(String key, String value) {
        Jedis jedis = getResource();
        jedis.set(key, value);
        returnResource(jedis);
    }

    @Override
    public String get(String key) {
        Jedis jedis = getResource();
        String value = jedis.lrange(key, 0, 10).toString();
        returnResource(jedis);
        return value;
    }
}
