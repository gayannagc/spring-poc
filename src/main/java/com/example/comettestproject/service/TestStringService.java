package com.example.comettestproject.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TestStringService {
    public String testMethod(String str) {
        return "test passed";
    }
}
