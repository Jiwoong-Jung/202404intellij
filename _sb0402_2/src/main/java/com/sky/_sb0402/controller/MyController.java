package com.sky._sb0402.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("name", "이순신");
        return "root";
    }
}
