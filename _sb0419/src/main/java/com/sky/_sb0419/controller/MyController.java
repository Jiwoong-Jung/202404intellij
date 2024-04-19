package com.sky._sb0419.controller;

import com.sky._sb0419.entity.Notice;
import com.sky._sb0419.repository.NoticeRepository;
import com.sky._sb0419.service.DetailService;
import com.sky._sb0419.service.NoticeService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MyController {
    private final NoticeRepository noticeRepository;
    private final DetailService detailService;
    private final NoticeService noticeService;

    @GetMapping("/")
    public String root() {
        return "view/index";
    }

    @GetMapping("/page2")
    public String listAction(Model model) {
        List<Notice> list = noticeRepository.findAll();
        model.addAttribute("list", list);
        return "view/list";
    }

}
