package com.example.comettestproject.mapper;

import com.example.comettestproject.util.exception.BaseException;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
public class Mapper {

    public String mapper(CompletableFuture<String> result1, CompletableFuture<String> result2, CompletableFuture<String> result3) throws BaseException {
//        System.out.println("mapper called");
        try {
            String result = result1.get() +"-"+result2.get()+"-"+ result3.get() +"-mapped";
            return result;

        }catch (Exception e){
            throw new BaseException("mapper errror");
        }
    }

}
