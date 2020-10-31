package com.example.comettestproject.repository;

import com.example.comettestproject.dto.tokenDto.UserCacheObject;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.concurrent.TimeUnit;

@Repository
public class CacheRepo2 {

    private final String prefix = "comet_";

    private RedisTemplate<String, String> redisTemplate;

    public CacheRepo2(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;

    }

    public void save(String userName, String uniqueId){
        redisTemplate.opsForHash().put(prefix+userName, userName , uniqueId);
        redisTemplate.expire(prefix+userName, 10 , TimeUnit.SECONDS);
    }

    public void saveWithoutExp(String userName, String uniqueId){
        redisTemplate.opsForHash().put(prefix+userName, userName, uniqueId);

    }

    public String getByUserName(String userName){
        return (String) redisTemplate.opsForHash().get(prefix+userName, userName);
    }

    public boolean exists(String userName){
        return redisTemplate.opsForHash().hasKey(prefix+userName, userName);
    }

    public Set<Object> getAll(){
        return redisTemplate.opsForHash().keys(prefix + "*");
    }

    public Set<String> getAll2(){
        return redisTemplate.keys(prefix + "*");
    }
}
