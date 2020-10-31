package com.example.comettestproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
public class AsyncConfiguration {

//    @Bean
//    public Executor asyncExecutor() {
//        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
//        return executor;
//    }

    @Bean
    public Executor asyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(200);
        executor.setMaxPoolSize(200);
        executor.setQueueCapacity(500);
        executor.setThreadNamePrefix("Async Process-");
        executor.initialize();
        return executor;
    }

    // Define a Spring bean of type TestAsyncClazz
//    @Bean
//    public TestClient1 testClient1() {
//        return new TestClient1();
//    }
//    @Bean
//    public TestClient2 testClient2() {
//        return new TestClient2();
//    }
//    @Bean
//    public TestClient3 testClient3() {
//        return new TestClient3();
//    }
}
