package com.sky._sb0507.spring;

public class TestException extends RuntimeException {
    public TestException(String message) {
        super(message);
        System.out.println("---------------------"+message);
    }
}
