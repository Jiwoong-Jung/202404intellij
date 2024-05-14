package com.sky.sp5ch14.controller;

import com.sky.sp5ch14.spring.TestException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class TestController {

    @GetMapping("/test")
    public void test() {
        System.out.println("-----------------test");
        throw new TestException("Test 예외");
//        return "test/test";
    }


    @ExceptionHandler(TestException.class)
    public String testException() {
        return "test/error";
    }
}
