package com.sky.sp5ch14.pizza.repository;

import com.sky.sp5ch14.pizza.entity.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PizzaRepository extends JpaRepository<Pizza, Long> {
    List<Pizza> findAllByCompleteFalse(); //SELECT * FROM pizza where complete = 0
}
