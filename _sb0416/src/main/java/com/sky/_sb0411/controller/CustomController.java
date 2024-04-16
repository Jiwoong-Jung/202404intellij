package com.sky._sb0411.controller;

import com.sky._sb0411.custom.Code;
import com.sky._sb0411.custom.FormCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/custom/form")
@Slf4j
public class CustomController {
    @GetMapping
    public String form(Model model, FormCommand formCommand) {
        formCommand.setLoginType("헤드헌터회원");
        List<String> loginTypes = new ArrayList<String>();
        loginTypes.add("일반회원");
        loginTypes.add("기업회원");
        loginTypes.add("헤드헌터회원");

        model.addAttribute("loginTypes", loginTypes);

        model.addAttribute("favoriteOsNames", new String[] {"윈도우8", "윈도우10", "맥OS"});

        model.addAttribute("favoriteOsCodes", Arrays.asList(
                new Code("01", "윈도우8"),
                new Code("02", "윈도우10")));

        List<Code> jobCodes = Arrays.asList(
                new Code("01", "프로그래머"),
                new Code("02", "디자이너"));
        model.addAttribute("jobCodes", jobCodes);
        return "/custom/form";
    }

    @PostMapping
    public String result(FormCommand formCommand) {
        log.info("{}", formCommand);
        return "/custom/result";
    }
}
