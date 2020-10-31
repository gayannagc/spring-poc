package com.example.comettestproject.client;

import com.example.comettestproject.util.exception.BaseException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

@Component
public class TestClient1 {



    @Async
    public CompletableFuture<String>  apiCall01(String key, ExecutorService executorService) throws BaseException {
        try {
            System.out.println("api call 01: " + Thread.currentThread().getName());
            if (true) throw new Exception("");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return CompletableFuture.completedFuture("api-01-" + key +"-result");
        }catch (Exception e){
            throw new BaseException("error-test");
        }
    }

//    @Async
//    public CompletableFuture<String> apiCall02(String key){
////        System.out.println("api 02 called");
//        return CompletableFuture.supplyAsync(() -> {
//            System.out.println("api call 02: " + Thread.currentThread().getName());
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            return "api-02-" + key +"-result";
//        });
//    }
//
//    @Async
//    public CompletableFuture<String> apiCall03(String key){
////        System.out.println("api 03 called");
//        return CompletableFuture.supplyAsync(() -> {
//            System.out.println("api call 03: " + Thread.currentThread().getName());
//            try {
//                Thread.sleep(5000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            return "api-03-" + key +"-result";
//        });
//    }
}
