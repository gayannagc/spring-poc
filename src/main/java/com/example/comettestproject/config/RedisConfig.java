package com.example.comettestproject.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;


@Configuration
public class RedisConfig {

    @Bean
    JedisConnectionFactory jedisConnectionFactory(){
        return new JedisConnectionFactory();
    }

    @Bean
    RedisTemplate<String, String> redisTemplate(){
        RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(jedisConnectionFactory());
        redisTemplate.setDefaultSerializer(new StringRedisSerializer());
        return redisTemplate;
    }

//    @Bean(destroyMethod = "shutdown")
//    public RedissonClient redissonClient() throws IOException {
//        Config config = Config.fromYAML(new File("redisson.yaml"));
//        return Redisson.create(config);
//    }
//
//    @Bean
//    public RedissonConnectionFactory redissonConnectionFactory() throws IOException {
//        return new RedissonConnectionFactory(redissonClient());
//    }
//
//    @Bean
//    RedisTemplate<String, UserCacheObject> redisTemplate() throws IOException {
//        RedisTemplate<String, UserCacheObject> redisTemplate = new RedisTemplate<>();
//        redisTemplate.setConnectionFactory(redissonConnectionFactory());
//        return redisTemplate;
//    }




}
