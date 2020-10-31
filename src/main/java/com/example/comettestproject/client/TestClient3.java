package com.example.comettestproject.client;

import com.example.comettestproject.util.ApiError;
import com.example.comettestproject.util.exception.BaseException;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.ExecutorService;

@Component
public class TestClient3 {



    @Async
    public CompletableFuture<String> apiCall03(String key,ExecutorService executorService) throws BaseException {
        try {
            System.out.println("api call 03: " + Thread.currentThread().getName());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            if (true) throw new Exception("");
            return CompletableFuture.completedFuture("api-03-" + key +"-result");
        }catch (Exception e){
            throw new BaseException("api error 03");
        }

    }
}
