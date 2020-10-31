//package com.example.comettestproject.repository;
//
//import com.example.comettestproject.dto.tokenDto.UserCacheObject;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.stereotype.Repository;
//
//import java.time.Duration;
//import java.util.Date;
//import java.util.concurrent.TimeUnit;
//
//@Repository
//public class CacheRepository implements RedisRepository {
//
//    private RedisTemplate<String,UserCacheObject> redisTemplate;
//
//    public CacheRepository(RedisTemplate<String, UserCacheObject> redisTemplate) {
//        this.redisTemplate = redisTemplate;
//
//    }
//
//    @Override
//    public void save(String userName, UserCacheObject userCacheObject) {
//        redisTemplate.opsForHash().put(userName, userName, userCacheObject);
//        redisTemplate.expire(userName, 10 , TimeUnit.SECONDS);
//    }
//
//    @Override
//    public void saveWithoutExp(String userName, UserCacheObject userCacheObject) {
//        redisTemplate.opsForHash().put(userName, userName, userCacheObject);
//
//    }
//
//    @Override
//    public void update(String userName, UserCacheObject userCacheObject) {
//        save(userName,userCacheObject);
//    }
//
//    @Override
//    public void delete(String userName) {
//        redisTemplate.opsForHash().delete(userName,userName);
//    }
//
//    @Override
//    public UserCacheObject findByUserName(String userName) {
//        return (UserCacheObject)redisTemplate.opsForHash().get(userName,userName);
//    }
//}
