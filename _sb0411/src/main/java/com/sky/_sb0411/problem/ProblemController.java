package com.sky._sb0411.problem;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/problem")
public class ProblemController {
    @GetMapping
    public String form() {
        return "problem/problemForm";
    }
}
