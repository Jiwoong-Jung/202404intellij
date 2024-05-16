package com.sky.restapi0516;

import com.sky.restapi0516.entity.TodoEntity;
import com.sky.restapi0516.repository.TodoRepository;
import com.sky.restapi0516.service.TodoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Restapi0516ApplicationTests {

    @Autowired
    TodoRepository todoRepository;

    @Autowired
    TodoService todoService;

    @Test
    void contextLoads() {

        System.out.println(todoService);

//        List<TodoEntity>  list = todoRepository.findByUserId(null);
//        System.out.println(list);

    }

}
