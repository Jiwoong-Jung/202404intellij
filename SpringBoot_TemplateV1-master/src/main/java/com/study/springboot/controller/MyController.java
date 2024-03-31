package com.study.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.study.springboot.spring.TestDao;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MyController {
	
	@Autowired
	TestDao testDao;
	
	@GetMapping("/main")
	public String main() {
		
		log.info("-----테스트: {}", testDao.count());
		return "test";
	}

}
