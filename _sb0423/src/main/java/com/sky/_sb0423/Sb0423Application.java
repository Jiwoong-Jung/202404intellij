package com.sky._sb0423;

import com.mysql.cj.protocol.x.Notice;
import com.sky._sb0423.pizza.entity.Pizza;
import com.sky._sb0423.pizza.repository.PizzaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.stream.IntStream;

@SpringBootApplication
@RequiredArgsConstructor
public class Sb0423Application {
    private final PizzaRepository pizzaRepository;
    public static void main(String[] args) {
        SpringApplication.run(Sb0423Application.class, args);
    }

    @PostConstruct
    private void init() {
        IntStream.rangeClosed(1, 5).forEach(i->{
            Pizza pizza = Pizza.builder()
                    .chilly(i)
                    .deeping(i)
                    .salad(i)
                    .total(24000)
                    .complete(false)
                    .build();
            pizzaRepository.save(pizza);
        });
    }
}
