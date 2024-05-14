package com.sky.restapi0513.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

    @GetMapping("/test")
    @ResponseBody
    public String test(@RequestParam long id) {
        return "테스트 "+id;
    }
}
