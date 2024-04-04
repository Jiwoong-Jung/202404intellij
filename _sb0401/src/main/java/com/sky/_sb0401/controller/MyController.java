package com.sky._sb0401.controller;

import com.sky._sb0401.entity.Memo;
import com.sky._sb0401.service.MemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@RestController
public class MyController {

    @Autowired
    MemoService memoService;

    @GetMapping("/")
    public Memo root() {
        memoService.emInsert();
        return memoService.emSelectOne(13L);
    }
}
