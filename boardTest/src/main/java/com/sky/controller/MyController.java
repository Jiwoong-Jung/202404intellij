package com.sky.controller;

import com.sky.entity.Notice;
import com.sky.repository.NoticeRepository;
import com.sky.service.DetailService;
import com.sky.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;


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
    public String listAction(Model model, @PageableDefault(page = 0, size = 10) Pageable pageable) {
        //List<Notice> list = noticeRepository.findAll();
        List<Notice> list = noticeRepository.findAllByOrderBySeqDesc();
        final int start = (int) pageable.getOffset();
        final int end = Math.min((start + pageable.getPageSize()), list.size());
        final Page<Notice> page = new PageImpl<>(list.subList(start, end), pageable, list.size());
        model.addAttribute("list", page);
        return "view/list";
    }

    @GetMapping("/detail")
    public String detail(Long seq, Model model) {
        Notice notice = detailService.detail(seq);
        model.addAttribute("notice", notice);
        return "view/detail";
    }

    @PostMapping("/addNotice")
    @ResponseBody
    public Notice addNotice(Notice notice) {
        return noticeService.saveNotice(notice);
    }

}
