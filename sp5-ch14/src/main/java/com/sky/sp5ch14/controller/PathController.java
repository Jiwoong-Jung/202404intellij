package com.sky.sp5ch14.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PathController {
    @GetMapping("/test/{num}")
    public String test(@PathVariable("num") int num) {
        if (num == 1) {
            return "test/test1";
        } else if (num == 2) {
            return "test/test2";
        } else {
            return "redirect:/test";
        }
    }

    @ExceptionHandler(NumberFormatException.class)
    public String numberFormatException() {
        return "test/error";
    }
}
