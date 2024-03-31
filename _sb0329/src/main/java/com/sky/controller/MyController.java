package com.sky.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.sky.model.Product;
import com.sky.repository.MemberMapper;
import com.sky.repository.ProductMapper;
import com.sky.service.OrderService;
import com.sky.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MyController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	MemberMapper memberMapper;
	
	@GetMapping("/")
	public String main(Model model) {
//		model.addAttribute("userName", "홍길동");
//		model.addAttribute("aaa123", "가나다");
//		model.addAttribute("product", 
//				    productService.getProductById(3L));
		return "root";
		// return "redirect:/list";
	}
	
	@GetMapping("/items")
	public String list(Model model) {
		model.addAttribute("list", productService.getAllProducts());
		return "list";
	}
	
	@GetMapping("/items/new")
	public String save() {
		return "save";
	}
	
	@PostMapping("/new")
	public String saveNew(Product product) {
		log.info("--------------------------------------------");
		log.info("product: {}", product.getProdName());
		log.info("product: {}", product.getProdPrice());
		productService.addProduct(product);
		return "redirect:/items";
	}
	
	@GetMapping("/orders")
	public String orders(Model model) {
		model.addAttribute("list", orderService.getAllOrders());
		return "orderList";
	}
	
	@GetMapping("/order")
	public String order(Model model) {
		model.addAttribute("list", memberMapper.selectAllMember());
		model.addAttribute("list2", productService.getAllProducts());
		return "orderForm";
	}
	
}
