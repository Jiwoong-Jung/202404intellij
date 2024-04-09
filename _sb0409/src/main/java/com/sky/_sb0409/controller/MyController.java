package com.sky._sb0409.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class MyController {

    @GetMapping("/")
    public String main() {
        return "main";
    }

    @ModelAttribute
    public void case1(Model model) {
        model.addAttribute("value1", "안녕?");
    }

    @ModelAttribute("value2")
    public String case2() {
        return "반갑네요";
    }
}
