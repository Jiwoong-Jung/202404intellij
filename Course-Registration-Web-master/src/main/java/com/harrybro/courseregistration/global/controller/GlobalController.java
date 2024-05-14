package com.harrybro.courseregistration.global.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GlobalController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

}
