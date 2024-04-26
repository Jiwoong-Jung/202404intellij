package com.sky._sb0423.pizza.repository;

import com.sky._sb0423.pizza.entity.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PizzaRepository extends JpaRepository<Pizza, Long> {
    List<Pizza> findAllByCompleteFalse(); //SELECT * FROM pizza where complete = 0
}
