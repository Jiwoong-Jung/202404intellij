package com.sky._sb0401.controller;

import com.sky._sb0401.entity.Board;
import com.sky._sb0401.entity.Member;
import com.sky._sb0401.entity.Memo;
import com.sky._sb0401.service.MemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Controller
public class MyController {

    @Autowired
    MemoService memoService;

    @GetMapping("/")
    public String root() {
        memoService.m1insert();
        Memo memo = memoService.emInsert();
        System.out.println(memoService.emSelectOne(memo.getMno()));
        return "main";
    }

    @GetMapping("/test")
    public String test() {
        Board board = memoService.getBoardOne(1L);
        System.out.println(board);
        return "main";
    }

    @GetMapping("/test2")
    public String test2() {
       Member member = memoService.getMemberOne(1L);
        System.out.println(member);
        return "main";
    }
}
