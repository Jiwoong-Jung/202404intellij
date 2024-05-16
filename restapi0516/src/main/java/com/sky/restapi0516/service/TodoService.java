package com.sky.restapi0516.service;

import com.sky.restapi0516.entity.TodoEntity;
import com.sky.restapi0516.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {


  @Autowired
  private TodoRepository repository;

  public String testService() {
    // TodoEntity 생성
    TodoEntity entity = TodoEntity.builder().title("My first todo item").userId("Kim").build();
    // TodoEntity 저장
    repository.save(entity);
    // TodoEntity 검색
    TodoEntity savedEntity = repository.findById(entity.getId()).get();
    return savedEntity.getTitle();
  }


}
