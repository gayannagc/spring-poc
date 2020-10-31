package com.example.comettestproject.client;

import com.example.comettestproject.util.exception.BaseException;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

@Component
public class TestClient2 {


    @Async
    public CompletableFuture<String> apiCall02(String key,ExecutorService executorService) throws BaseException {
        try {
////        System.out.println("api 02 called");
//        return CompletableFuture.supplyAsync(() -> {
            System.out.println("api call 02: " + Thread.currentThread().getName());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return CompletableFuture.completedFuture("api-02-" + key +"-result");
//        },executorService);

        }catch (Exception e){
            throw new BaseException("api error 01");
        }
    }
}
