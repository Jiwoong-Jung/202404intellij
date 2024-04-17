package com.sky.controller;

import com.sky.repository.IMemberDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

    @Autowired
    IMemberDao iMemberDao;

    @GetMapping("/count")
    @ResponseBody
    public int count() {
        return iMemberDao.countMember();
    }

    @GetMapping("/")
    public String main() {
        return "main";
    }
}
