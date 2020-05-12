package com.example.test.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author Admin
 * @date 2020/5/11
 */
@Service
public class RedisPoolFactory {
    @Autowired
    RedisConfig redisConfig;

    @Bean
    public JedisPool JedisPoolFactory(){
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxIdle(redisConfig.getPoolMaxldle());
        poolConfig.setMaxWaitMillis(redisConfig.getPoolMaxWait()*1000);
        poolConfig.setMaxTotal(redisConfig.getPoolMaxTotal());
        poolConfig.setTestOnCreate(false);
        JedisPool jp = new JedisPool(poolConfig, redisConfig.getHost(),redisConfig.getPort(),redisConfig.getTimeout()*1000,redisConfig.getPassword(),0);
        return jp;

    }


}
