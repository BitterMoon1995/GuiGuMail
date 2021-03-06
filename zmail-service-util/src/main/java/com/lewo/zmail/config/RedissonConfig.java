package com.lewo.zmail.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedissonConfig {
    @Value("${spring.redis.host:0}")
    private String host;

    @Value("${spring.redis.port:6379}")
    private String port;

    @Bean
    public RedissonClient redissonClient(){
        Config config = new Config();
//        config.useSingleServer().setAddress("redis://"+host+":"+port);
        config.useSingleServer().setPassword("godz1995");
        config.useSingleServer().setAddress("redis://192.168.156.128:6379");
        return Redisson.create(config);
    }
}
