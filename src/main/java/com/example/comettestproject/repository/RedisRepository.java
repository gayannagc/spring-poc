package com.example.comettestproject.repository;

import com.example.comettestproject.dto.tokenDto.UserCacheObject;

public interface RedisRepository {

    void save(String userName, UserCacheObject userCacheObject);
    void update(String userName,  UserCacheObject userCacheObject);
    void delete(String userName);
    UserCacheObject findByUserName(String userName);
    void saveWithoutExp(String userName, UserCacheObject userCacheObject);


}
