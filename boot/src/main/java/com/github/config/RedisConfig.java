package com.github.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by chenqimiao on 2017/5/2.
 */
@Configuration
public class RedisConfig implements EnvironmentAware {
    private Environment env;

    private Logger log = LoggerFactory.getLogger(RedisConfig.class);

    @Override
    public void setEnvironment(Environment environment) {
        this.env = environment;
    }

    @Bean("jedisPoolConfig")
    public JedisPoolConfig jedisPoolConfig(){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(env.getProperty("redis.maxIdle",Integer.class));
        jedisPoolConfig.setMaxWaitMillis(env.getProperty("redis.maxWait",Integer.class));
        jedisPoolConfig.setTestOnBorrow(env.getProperty("redis.testOnBorrow",Boolean.class));
        return jedisPoolConfig;
    }
    @Bean(name="jedisConnectionFactory")
    public JedisConnectionFactory jedisConnectionFactory(JedisPoolConfig jedisPoolConfig) {
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
        jedisConnectionFactory.setHostName(env.getProperty("redis.host"));
        jedisConnectionFactory.setPort(Integer.parseInt(env.getProperty("redis.port")));
        jedisConnectionFactory.setPoolConfig(jedisPoolConfig);
        //jedisConnectionFactory.setPassword();  //有密码时设置
        jedisConnectionFactory.afterPropertiesSet();
        return jedisConnectionFactory;
    }


    @Bean
    public RedisTemplate redisTemplate(JedisConnectionFactory jedisConnectionFactory) {
        RedisTemplate redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(jedisConnectionFactory);
        //key序列化方式;（不然会出现乱码;）,但是如果方法上有Long等非String类型的话，会报类型转换错误；

        //所以在没有自己定义key生成策略的时候，以下这个代码建议不要这么写，可以不配置或者自己实现ObjectRedisSerializer

        //或者JdkSerializationRedisSerializer序列化方式;

        RedisSerializer<String> redisSerializer = new StringRedisSerializer();//Long类型不可以会出现异常信息;

        redisTemplate.setKeySerializer(redisSerializer);

        redisTemplate.setHashKeySerializer(redisSerializer);

        return redisTemplate;
    }





}
