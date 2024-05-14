package com.sky.restapi0513.controller;

import com.sky.restapi0513.dto.TestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test2")
    public String test() {
        return "테스트2";
    }

    @GetMapping("/test3/{id}")
    public String test3(@PathVariable long id) {
        return "테스트3: " + id;
    }

    @GetMapping("/test4/{id}")
    public ResponseEntity<TestDto> test4(@PathVariable long id) {
        TestDto testDto = new TestDto(id, "REST API 테스트");
        return ResponseEntity.ok(testDto);
    }
}
