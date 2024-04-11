package com.sky._sb0411.problem;

import com.sky._sb0411.survey.Question;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

@Controller
@RequestMapping("/problem")
@Slf4j
public class ProblemController {
    @GetMapping
    public String form(Model model) {

        Question q1 = new Question("당신의 역할은 무엇입니까?",
                Arrays.asList("백엔드", "프론트", "DBA", "웹디자인"));
        Question q1 = new Question("당신의 역할은 무엇입니까?",
                Arrays.asList("백엔드", "프론트", "DBA", "웹디자인"));
        model.addAttribute("question", q1);
        return "problem/problemForm";
    }

    @PostMapping
    public String submit(@ModelAttribute("ansData") Answer ans) {
        log.info("응답자료 {}", ans);
        return "problem/submitted";
    }
}
