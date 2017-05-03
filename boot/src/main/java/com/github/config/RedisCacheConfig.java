package com.github.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;

import java.lang.reflect.Method;

/**
 * Created by chenqimiao on 2017/5/2.
 */
@Configuration
@EnableCaching
public class RedisCacheConfig  extends CachingConfigurerSupport implements EnvironmentAware {
    private Environment env;
    @Override
    public void setEnvironment(Environment environment) {
        this.env = environment;
    }

    @Bean
    public CacheManager cacheManager(RedisTemplate<?,?> redisTemplate) {

        CacheManager cacheManager = new RedisCacheManager(redisTemplate);

        return cacheManager;

    }

    @Override
    public KeyGenerator keyGenerator() {
        return new KeyGenerator() {
            @Override
            public Object generate(Object o, Method method, Object... objects) {
                StringBuilder sb = new StringBuilder();
                sb.append(o.getClass().getName());
                sb.append(method.getName());
                for (Object ob : objects){
                    sb.append(ob.toString());
                }
                return sb.toString();
            }
        };
    }
}
