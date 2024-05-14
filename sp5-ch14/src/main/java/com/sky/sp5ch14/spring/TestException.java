package com.sky.sp5ch14.spring;

public class TestException extends RuntimeException {
    public TestException(String message) {
        super(message);
        System.out.println("---------------------"+message);
    }
}
