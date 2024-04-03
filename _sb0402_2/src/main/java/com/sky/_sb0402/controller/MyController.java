package com.sky._sb0402.controller;

import com.sky._sb0402.repository.MyDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {

    @Autowired
    MyDataRepository myDataRepository;

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("name", "이순신");
//        model.addAttribute("list", myDataRepository.findAll());
        model.addAttribute("list", myDataRepository.findAll2());
        return "root";
    }

    @GetMapping("show")
    public String showView(Model model) {
        // Model에 데이터 추가
        model.addAttribute("name", "이순신");

        // 반환값으로 뷰 이름을 설정
        return "useThymeleaf";
    }
}
