package com.example.demo;

import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
public class EmployeeController {

	private EmployeeRepository repository;

	public EmployeeController(EmployeeRepository repository) {
		this.repository = repository;
	}

	@GetMapping
	public String home(Model model, HttpServletRequest request) {
		model.addAttribute("employees", repository.findAll());
		model.addAttribute("isManager", request.isUserInRole("ROLE_MANAGER"));
		model.addAttribute("newEmployee", new Employee());
		return "home";
	}

	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {
		repository.deleteById(id);
		return "redirect:/";
	}

	@PostMapping("/add")
	public String add(@ModelAttribute Employee newEmployee) {
		repository.save(newEmployee);
		return "redirect:/";
	}
}
