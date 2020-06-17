package com.example.springboottest.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Component
@PropertySource("classpath:application.properties")
@ConfigurationProperties(prefix = "spring.redis")
public class RedisConfig {
    private String host;
    private int port;
    private int timeout;

    public JedisPoolConfig getJedisConfig() {
        return new JedisPoolConfig();
    }

    @Bean
    public JedisPool getJedisPool() {
        return new JedisPool(getJedisConfig(), host, port);
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }
}
