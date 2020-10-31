package com.example.comettestproject;

import com.example.comettestproject.dto.tokenDto.JWTToken;
import com.example.comettestproject.dto.tokenDto.UserCacheObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@EnableAsync
public class CometTestProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(CometTestProjectApplication.class, args);

	}

}
