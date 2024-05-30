package com.sky.restapi0516.controller;

import com.sky.restapi0516.dto.ResponseDTO;
import com.sky.restapi0516.entity.TodoEntity;
import com.sky.restapi0516.repository.TodoRepository;
import com.sky.restapi0516.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("todo")
public class TodoController {

  @Autowired
  private TodoService service;

  @Autowired
  TodoRepository todoRepository;

  @GetMapping("/test")
  public ResponseEntity<?> testTodo() {
    String str = service.testService(); // 테스트 서비스 사용
    System.out.println("1--------------------------------");
    System.out.println(todoRepository.findByUserId("Kim"));
    System.out.println("2--------------------------------");
//    System.out.println(todoRepository.findByUserIdQuery("Kim"));

    List<String> list = new ArrayList<>();
    list.add(str);
    ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();
    return ResponseEntity.ok().body(response);
  }

  @GetMapping("/groups")
  Collection<TodoEntity> groups() {
    return todoRepository.findAll();
  }

}
