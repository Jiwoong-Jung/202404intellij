package com.sky._sb0401.controller;

import com.sky._sb0401.entity.Memo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Controller
public class MyController {

    @PersistenceContext
    EntityManager em;

    @GetMapping("/")
    @Transactional
    public String root() {
        Memo memo = Memo.builder()
                .mno(3L)
                .memoText("이것은 EM 테스트22222")
                .build();
        em.merge(memo);
        em.flush();
        return "main";
    }

}
