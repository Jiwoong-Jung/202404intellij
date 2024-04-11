package com.sky._sb0411.problem;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/problem")
@Slf4j
public class ProblemController {
    @GetMapping
    public String form() {
        return "problem/problemForm";
    }

    @PostMapping
    public String submit(Answer answer) {
        log.info("응답자료 {}", answer);
        return "problem/submitted";
    }
}
