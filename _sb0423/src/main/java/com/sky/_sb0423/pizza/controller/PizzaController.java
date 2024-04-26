package com.sky._sb0423.pizza.controller;

import com.sky._sb0423.pizza.entity.Pizza;
import com.sky._sb0423.pizza.repository.PizzaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
public class PizzaController {

    private final PizzaRepository pizzaRepository;

    @GetMapping("/pizza")
    public String form() {
        return "pizza/form";
    }

    @PostMapping("/pizza")
    public String result(Pizza pizza) {
        log.info("{}", pizza);
        pizzaRepository.save(pizza);
        return "pizza/result";
    }
    @GetMapping("/orderList")
    public String orderList(Model model) {
        model.addAttribute("list", pizzaRepository.findAllByCompleteFalse());
        return "pizza/orderList";
    }

}
