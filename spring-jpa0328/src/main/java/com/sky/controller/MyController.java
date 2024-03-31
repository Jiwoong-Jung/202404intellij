package com.sky.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sky.model.Product;
import com.sky.repository.ProductMapper;

@Controller
public class MyController {
	
	@Autowired
	ProductMapper productMapper;
	
	@GetMapping("/")
	public String main(Model model) {
		model.addAttribute("posts", productMapper.selectAllProducts());
		model.addAttribute("userName", "홍길동");
		model.addAttribute("post", productMapper.selectProductById(2L));
		model.addAttribute("aaa1", "가나다");
		return "first1";
	}
	
	@ResponseBody
	@GetMapping("/test")
	public String test() {

	  return "hello";
	}
	
	@ResponseBody
	@GetMapping("/test2")
	public Product test2() {
	  return productMapper.selectProductById(3L);
	}

}
