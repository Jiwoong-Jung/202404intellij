package com.sky._sb0401.controller;

import com.sky._sb0401.entity.Memo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@RestController
public class MyController {



    @GetMapping("/")
    public String root() {

        return "main";
    }

}
